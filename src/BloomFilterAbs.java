package src;

public abstract class BloomFilterAbs {

    // POST
    public BloomFilterAbs(int size) {}

    // COMMANDS:
    // PRE: There are free slots in the hash table
    public abstract void put(String value);
    // POST: New value is added into the table

    // REQUESTS:
    public abstract boolean checkElement(String value);

    public abstract int get_put_status(); //  method hadn't been evoked yet - worked correctly worked with error

    public abstract int get_checkElement_status(); // been evoked - hadn't been evoked
}