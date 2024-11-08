package src;

abstract class LinkedList<T> {

    // CONSTRUCTOR:
    public abstract LinkedList<T> LinkedList();


    public abstract void head();

    public abstract void tail();

    public abstract void right();

    public abstract T get();

    public abstract void put_right(T node);

    public abstract void put_left(T node);

    public abstract void remove();

    public abstract void clear();

    public abstract void size();

    public abstract void add_to_empty();


    public abstract void add_tail(T node);
    public abstract void replace(T node);
    public abstract void find(T value);
    public abstract void remove_all(T value);

    public abstract Boolean is_head();
    public abstract Boolean is_tail();
    public abstract Boolean is_value();


}
