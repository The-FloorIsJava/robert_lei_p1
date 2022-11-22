package net.revature.project1.robert.ticket;

import net.revature.project1.robert.connections.ConnectionFactory;
import net.revature.project1.robert.util.CRUD;
import net.revature.project1.robert.util.CurrentUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements CRUD<Ticket> {

    @Override
    public Ticket create(Ticket newObject) {
        try(Connection connect = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "INSERT INTO tickets (ticket_description, amount, submitter_user) VALUES (?,?,?);";
            PreparedStatement prepStatement = connect.prepareStatement(sql);
            prepStatement.setString(1, newObject.getTicketDescription());
            prepStatement.setDouble(2, newObject.getAmount());
            prepStatement.setString(3, newObject.getSubmitterUser());
            int insertCheck = prepStatement.executeUpdate();
            if(insertCheck==0){
                throw new RuntimeException("ticket not inserted");
            }
            return newObject;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Ticket findById(String username) {
        return null;
    }
    public List<Ticket> findPendingTickets(){ //TODO
        List<Ticket> pending = new ArrayList<Ticket>();
        try(Connection connect = ConnectionFactory.getConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM tickets WHERE status=pending;";
            PreparedStatement prepStatement= connect.prepareStatement(sql);
            ResultSet results = prepStatement.executeQuery();
            while(results.next()){
                pending.add(convertTicket(results));
            }
            return pending;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Ticket> findPreviousTickets(String username){ //TODO
        List<Ticket> previous = new ArrayList<Ticket>();
        try(Connection connect = ConnectionFactory.getConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM tickets WHERE submitter_user=?;";
            PreparedStatement prepStatement= connect.prepareStatement(sql);
            prepStatement.setString(1, username);
            ResultSet results = prepStatement.executeQuery();
            while(results.next()){
                previous.add(convertTicket(results));
            }
            return previous;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param updated ticket that has correct ID, and status changed
     * @return returns if ticket has had status changed
     */
    @Override
    public boolean update(Ticket updated) { //TODO
        try(Connection connect = ConnectionFactory.getConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM tickets WHERE ticket_id=?;";
            PreparedStatement prepStatement= connect.prepareStatement(sql);
            prepStatement.setInt(1, updated.getTicketId());
            ResultSet results = prepStatement.executeQuery();
            if(!results.next()){
                return false;
            }
            Ticket notUpdated = convertTicket(results);
            if(!notUpdated.getStatus().equalsIgnoreCase("pending")){
                return false;
            }else{
                String updateSql = "UPDATE tickets SET status=? WHERE ticket_id=?;";
                PreparedStatement updatePrepStatement= connect.prepareStatement(updateSql);
                updatePrepStatement.setString(1,updated.getStatus());
                updatePrepStatement.setInt(2, updated.getTicketId());
                return(updatePrepStatement.executeUpdate()!=0);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
    private Ticket convertTicket(ResultSet result) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(result.getInt("ticket_id"));
        ticket.setTicketName(result.getString("ticket_name"));
        ticket.setTicketType(result.getString("ticket_type"));
        ticket.setTicketDescription(result.getString("ticket_description"));
        ticket.setAmount(result.getDouble("amount"));
        ticket.setStatus(result.getString("status"));
        ticket.setSupportingImage(result.getBytes("supporting_image"));
        ticket.setSubmitterUser(result.getString("submitter_user"));
        return ticket;
    }
}
