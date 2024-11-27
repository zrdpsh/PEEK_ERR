package src;

public abstract class NativeDictionaryAbs<T> {

    public final int PUT_STATUS_NIL = 0;
    public final int PUT_STATUS_OK = 1;

    public final int GET_STATUS_NIL = 0;
    public final int GET_STATUS_OK = 1;

    public final int IS_KEY_STATUS_NIL = 0;
    public final int IS_KEY_STATUS_OK = 1;

    public int size;
    public String [] slots;
    public T [] values;

    public  NativeDictionaryAbs(int sz, Class clazz) {};
    //POST: empty native dictionary is created

    //COMMANDS:

    //PRE: there are free slots in the dictionary
    public abstract void put(String key, T value);
    //POST: new value

    //PRE: there is an element with given value
    public abstract T get(String key);
    //POST: we get the value of an element


    //REQUESTS:

    public abstract boolean isKey(String key);
    //POST: returns true or false, if there is no such element

    public abstract int get_isKey_status();
    public abstract int get_put_status();
    public abstract int get_get_status();

}
