package src;

abstract class ParentListAbs<T> {

    public final int HEAD_NIL = 0; // get hasn't been evoked yet
    public final int HEAD_OK = 1; // last get() method has run correctly

    public final int TAIL_NIL = 0; // get hasn't been evoked yet
    public final int TAIL_OK = 1; // last get() method has run correctly

    public final int PUT_RIGHT_NIL = 0; // put right hasn't been evoked yet
    public final int PUT_RIGHT_OK = 1; // last put_right() has run correctly
    public final int PUT_RIGHT_ERR = 2; // cursor points at null element

    public final int PUT_LEFT_NIL = 0; // put left hasn't been evoked yet
    public final int PUT_LEFT_OK = 1; // last put_left() has run correctly
    public final int PUT_LEFT_ERR = 2; // cursor points at null element

    public final int RIGHT_NIL = 0; // right hasn't been evoked yet
    public final int RIGHT_OK = 1; // last right() method has run correctly
    public final int RIGHT_ERR = 2; // cursor doesn't move to the right

    public final int GET_NIL = 0; // get hasn't been evoked yet
    public final int GET_OK = 1; // last get() method has run correctly

    public final int REMOVE_NIL = 0; // remove hasn't been evoked yet
    public final int REMOVE_OK = 1; // last remove method has run correctly
    public final int REMOVE_ERR = 2; // cursor points at the null

    public final int REPLACE_NIL = 0; // remove hasn't been evoked yet
    public final int REPLACE_OK = 1; // last remove method has run correctly

    public final int FIND_NIL = 0; // remove hasn't been evoked yet
    public final int FIND_OK = 1; // last remove method has run correctly
    public final int FIND_ERR = 2; // cursor points at the null



    // CONSTRUCTOR:
    public abstract ParentListAbs<T> ParentListAbs();
    // POST: new empty list is created


    // COMMANDS:

    //PRE: if the list is empty, cursor points at the null
    public abstract void head();
    //POST: cursor points at the first node in the list

    //PRE: if the list is empty, cursor points at the null
    public abstract void tail();
    //POST: cursor points at the last node in the list

    //PRE: list is not empty
    public abstract void put_right(T value);
    //POST: new element is added to the right of the current element

    //PRE: list is not empty
    public abstract void put_left(T value);
    //POST: new element is added to the left of the current element

    //PRE: there is an element to the right of the cursor
    public abstract void right();
    //POST: cursor points at the element to the right of the current element

    //PRE: there is an element to the right of the cursor
    public abstract void left();
    //POST: cursor points at the element to the right of the current element

    //PRE: list is not empty
    public abstract void remove();
    //POST: cursor points at the element to the right of the current element,
    //if there was no right element - then the cursor points at the element to the left of the current element

    public abstract void clear();
    //POST: head and tail point at the null, size of the list is 0


    public abstract void add_tail(T value);
    //POST: tail points at the newly added element

    //PRE: list is not empty
    public abstract void replace(T value);
    //POST: current node's value is replaced with the new value

    public abstract void find(T value);
    //POST: cursor points at the element which value equals necessary value OR points at the null

    public abstract void remove_all(T value);
    //POST: there are no elements equal the to value in the list


    //REQUESTS:
    //PRE: the list is not empty
    public abstract T get();
    public abstract int size();

    public abstract Boolean is_head();
    public abstract Boolean is_tail();
    public abstract Boolean is_value();

    public abstract int get_head_status(); // done OR the list is empty
    public abstract int get_tail_status(); // done OR the list is empty
    public abstract int get_right_status(); // done OR there was no element to the right
    public abstract int get_left_status(); // done OR there was no element to the left
    public abstract int get_put_right_status(); // done OR the list is empty
    public abstract int get_put_left_status(); // done OR the list is empty
    public abstract int get_remove_status(); // done OR the list is empty
    public abstract int get_replace_status(); // done OR the list is empty
    public abstract int get_find_status(); // the next element is found;
    // the next element is not found; the list is empty
    public abstract int get_get_status(); // done OR the list is empty
}

