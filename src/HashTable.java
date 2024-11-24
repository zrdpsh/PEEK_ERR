package src;

public class HashTable extends HashTableAbs {



    private int size;
    private int step;
    private String[] slots;
    private final int DEFAULT_STEP = 3;
    private int putStatus;
    private int removeStatus;
    private int checkElementStatus;


    public HashTable(int size) {
        super(size);

        putStatus = PUT_STATUS_NIL;
        removeStatus = REMOVE_STATUS_NIL;
        checkElementStatus = CHECK_STATUS_NIL;

        this.size = size;
        step = DEFAULT_STEP;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    private int hashFun(String value) {
        char[] charArr = new char[value.length()];
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            charArr[i] = value.charAt(i);
            sum += charArr[i] - '0';
        }
        return (sum % size);
    }


    private int seekSlot(String value) {
        int i;
        i = hashFun(value);
        i = checkIndex(i, value);
        return i;
    }

    private int checkIndex(int i, String key) {

        i = checkWithStep(i, key);

        if (i >= size) {
            i = checkEachElement(i, key);
        }

        if (i >= size) {
            return -1;
        }
        return i;
    }

    private int checkWithStep(int i, String key) {
        while (i < size && slots[i] != null) {
            if (slots[i].equals(key)) {
                break;
            }
            i += step;
        }
        return i;

    }

    private int checkEachElement(int i, String key) {
        i = 0;
        while (i < size && slots[i] != null) {
            if (slots[i].equals(key)) {
                break;
            }
            i++;
        }
        return i;
    }


    @Override
    public void put(String value) {
        int i;
        i = seekSlot(value);
        if (i != -1) {
            slots[i] = value;
            putStatus = PUT_STATUS_OK;
        }
        putStatus = PUT_STATUS_ERR;
    }


    @Override
    public void remove(String value) {
        int foundIndex = find(value);
        if (foundIndex != -1) {
            removeStatus = REMOVE_STATUS_OK;
            slots[foundIndex] = null;
            return;
        }
        removeStatus = REMOVE_STATUS_ERR;
    }

    @Override
    public boolean checkElement(String value) {
        int foundIndex = find(value);
        checkElementStatus = CHECK_STATUS_OK;
        return foundIndex != -1;
    }


    private int find(String value) {
        int i = hashFun(value);
        if (value.equals(slots[i])) {
            return i;
        } else {
            for (i = 0; i < size; i++) {
                if (value.equals(slots[i])) {
                    return i;
                }
            }
            return -1;
        }
    }

    @Override
    public int get_remove_status() {
        return removeStatus;
    }

    @Override
    public int get_checkElement_status() {
        return checkElementStatus;
    }

    @Override
    public int get_put_status() {
        return putStatus;
    }

}