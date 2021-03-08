package DAO;

import java.util.List;

public abstract class DAO<T> {

    public abstract boolean create(T obj);

    public abstract List<T> read();

    public  abstract boolean update(T obj);

    public abstract boolean delete(T obj);

}