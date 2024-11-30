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

    public HashTableAbs() {
    }

    //COMMANDS:

    // PRE: there are empty slots in the hash table
    public abstract void put(String value);
    // POST: given value is added to the hash table

    // PRE: there is an element with the given value
    public abstract void remove(String value);
    // POST: there is no element with given value

    public abstract boolean isExist(String value);




    // REQUESTS:

    public abstract int size();
    public abstract int get_remove_status(); // didn't evoked yet; evoked succesfully; doesn't removed
    public abstract int get_put_status(); // didn't evoked yet; evoked succesfully; evoked with error
    public abstract int get_checkElement_status(); // didn't evoked yet; evoked succesfully;
}
