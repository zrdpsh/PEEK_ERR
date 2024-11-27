package src;

public abstract class HashTableAbs {

    public final int PUT_STATUS_NIL = 0;
    public final int PUT_STATUS_OK = 1;
    public final int PUT_STATUS_ERR = 2;

    public final int REMOVE_STATUS_NIL = 0;
    public final int REMOVE_STATUS_OK = 1;
    public final int REMOVE_STATUS_ERR = 2;

    public final int CHECK_STATUS_NIL = 0;
    public final int CHECK_STATUS_OK = 1;

    public int size;
    public int step;
    public String[] slots;

    // CONSTRUCTOR:
    public HashTableAbs(int size) {
        this.size = size;
    }
    // POST: hash table with the given size is created


    //COMMANDS:
    public abstract void put(String value);
    // POST: given value is added to the hash table

    public abstract void remove(String value);
    // POST: there is no element with given value

    public abstract boolean checkElement(String value);


    // REQUESTS:
    public abstract int get_remove_status();
    public abstract int get_put_status();
    public abstract int get_checkElement_status();
}
