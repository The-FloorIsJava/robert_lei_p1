package net.revature.project1.robert.util;

public interface CRUD<T> {
    T create(T newObject);

    T findById(String username);

    boolean update(T updated);

    boolean delete(String id);
}
