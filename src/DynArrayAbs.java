package src;

public abstract class DynArrayAbs<T> {

    public final int APPEND_NIL = 0; // append hasn't been evoked yet
    public final int APPEND_OK = 1; // last append() method has run correctly

    public final int INSERT_NIL = 0; // insert hasn't been evoked yet
    public final int INSERT_OK = 1; // last insert() method has run correctly
    public final int INSERT_ERR = 2; // new element hasn't been inserted

    public final int GET_OK = 0; // get hasn't been evoked yet
    public final int GET_ERR = 1; // last get() method has run correctly

    public final int REMOVE_OK = 0; // last remove method has run correctly
    public final int REMOVE_ERR = 1; // cursor points at the null

    public abstract void makeArray(int newVolume);
    // POST: new massive with default length has been created

    public abstract T getItem(int index);
    // POST: element with given index has been returned

    // PRE: there is some array
    public abstract void append(T item);
    // POST: new element has been added to the end of an array

    public abstract void insert(T item, int index);
    // POST: new index points at the new element

    public abstract void remove(int index);
    // POST: there is no element at the given index

    public abstract int get_append_status();
    public abstract int get_remove_status();
    public abstract int get_get_item_status();
    public abstract int get_insert_status();
}
