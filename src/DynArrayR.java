package src;

public class DynArrayR<T> extends DynArrayAbs<T> {

    private int appendStatus;
    private int getItemStatus;
    private int removeStatus;
    private int insertStatus = INSERT_NIL;

    private final int DEFAULT_CAPACITY = 16;

    public T[] array;
    public int count;
    public int volume;
    Class clazz;

    public DynArray(Class c) {
        clazz = c;
        count = 0;
        makeArray(DEFAULT_CAPACITY);
    }

    public void makeArray(int newVolume) {
        int prevVolume = this.volume;
        if (count = 0) {
            this.array = (T[]) java.lang.reflect.Array.newInstance(this.clazz, newVolume);
        }

        if (count != 0) {
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, newVolume);
            if (prevVolume < newVolume) {
                System.arraycopy(this.array, 0, newArray, 0, this.array.length);
            }
            if (prevVolume > newVolume) {
                System.arraycopy(this.array, 0, newArray, 0, newArray.length);
            }
            this.array = newArray;
        }
        this.volume = newVolume;
    }

    public T getItem(int index) {
        if (index < 0 | index >= volume) {
            getItemStatus = GET_ERR;
            return null;
        }
        getItemStatus = GET_OK;
        return this.array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= this.volume || index >= this.count) {
            removeStatus = REMOVE_ERR;
        }

        int howMuchMovedElements = this.count - index - 1;
        if (howMuchMovedElements < 1) {
            howMuchMovedElements = this.volume - this.count;
        }

        T[] movedElements = (T[]) java.lang.reflect.Array.newInstance(this.clazz, howMuchMovedElements);
        System.arraycopy(this.array, index+1, movedElements, 0, howMuchMovedElements);
        System.arraycopy(movedElements, 0, this.array, index, howMuchMovedElements);

        if (this.count - 1 < (this.volume / 2) && (this.volume != 16)) {
            int newVolume = (int) ((this.volume / 1.5 < 16) ? 16 : this.volume/ 1.5);
            makeArray(newVolume);
        }
        this.count-=1;
        this.array[this.count] = null;
        removeStatus = REMOVE_OK;
    }

    public void append(T item) {
        if ((this.count + 1) > this.volume) {
            makeArray(this.volume * 2);
        }
        this.array[count] = item;
        this.count+=1;
        appendStatus = APPEND_OK;
    }

    public void insert(T item, int index) {
        if(index < 0 || index >= (volume + 2)) {
            insertStatus = INSERT_ERR;
        }

        if((this.count + 1) > this.volume) {
            makeArray(this.volume * 2);
        }

        if (index == (this.count - 1)) {
            append(item);
        }
        if (index != (this.count - 1)) {
            int howMuchMovedElements = this.count - index;
            T[] movedElements = (T[]) java.lang.reflect.Array.newInstance(this.clazz, howMuchMovedElements);
            System.arraycopy(this.array, index, movedElements, 0, howMuchMovedElements);
            int newVolume = ((this.count + 1) > this.volume) ? this.volume * 2 : this.volume;

            if (newVolume != this.volume) {
                makeArray(newVolume);
            }
            this.array[index] = item;

            System.arraycopy(movedElements, 0 ,this.array, index + 1, howMuchMovedElements);
            this.count+=1;
            insertStatus = INSERT_OK;
        }
    }




    public int get_append_status() {
        return appendStatus;
    }

    public int get_remove_status() {
        return removeStatus;
    }


    public int get_get_item_status() {
        return getItemStatus;
    }

    public int get_insert_status() {
        return insertStatus;
    }
}
