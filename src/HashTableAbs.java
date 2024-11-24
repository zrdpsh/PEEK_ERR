package src;

public abstract class HashTableAbs {
    public int size;
    public int step;
    public String[] slots;

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
