package src;

public abstract class PowerSetAbs extends HashTableAbs {

    public PowerSetAbs(int size) {
        super(size);
    }
    // POST: new empty set of given size is created

    //COMMANDS:
    @Override
    public abstract void put(String value);
    // POST: given value is added to the powerSet

    @Override
    public abstract void remove(String value);
    // POST: there is no element with given value

    @Override
    public abstract boolean isExist(String value);

    public abstract PowerSet intersection(PowerSet anotherSet);
    // POST: intersection of given powerSets are returned

    public abstract PowerSet union(PowerSet anotherSet);
    // POST: returns union of given sets

    public abstract PowerSet difference(PowerSet anotherSet);
    // POST: returns difference of given sets

    public abstract boolean isSubset(PowerSet anotherSet);
    // POST: returns true if current set is a subset of given set


    // REQUESTS:
    public abstract int get_remove_status();
    public abstract int get_put_status();
    public abstract int get_isExist_status();

}
