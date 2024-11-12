package src;

abstract class LinkedListDraft<T> {

    public const int PUT_RIGHT_NIL = 0; // put right hasn't been evoked yet
    public const int PUT_RIGHT_OK = 1; // last put_right() has run correctly
    public const int PUT_RIGHT_ERR = 2; // cursor points at null element

    public const int RIGHT_NIL = 0; // right hasn't been evoked yet
    public const int RIGHT_OK = 1; // last right() method has run correctly
    public const int RIGHT_ERR = 2; // cursor doesn't move to the right

    public const int GET_NIL = 0; // get hasn't been evoked yet
    public const int GET_OK = 1; // last get() method has run correctly

    public const int REMOVE_NIL = 0; // remove hasn't been evoked yet
    public const int REMOVE_OK = 1; // last remove method has run correctly
    public const int REMOVE_ERR = 2; // cursor points at the null

    // CONSTRUCTOR:
    public abstract LinkedListDraft<T> LinkedList();
    // POST: new empty list is created


    // COMMANDS:

    //PRE: if the list is empty, cursor points at the null
    public abstract void head();

    //PRE: if the list is empty, cursor points at the null
    public abstract void tail();
    //POST: the element under the cursor is linked to the null to the right

    //PRE: cursor doesn't point at the null element
    public abstract void put_right(T value);
    //POST: new element is added to the right of the current element

    public abstract void put_left(T node);
    //POST: new element is added to the left of the current element

    //PRE: there is an element to the right of the cursor
    public abstract void right();
    //POST: cursor points at the element to the right of the current element

    //PRE: cursor doesn't point at the null element
    public abstract void remove();
    //POST: cursor points at the element to the right of the current element,
    //if there was no right element - then the cursor points at the element to the left of the current element
    public abstract void clear();
    //POST: head and tail point at the null, size of the list is 0


    public abstract void add_tail(T node);
    //POST: tail points at the newly added element
    public abstract void replace(T node);
    //POST: next element of the added element is the same as the next element of the removed element
    public abstract void find(T value);
    //POST: cursor points at the element which value equals necessary value OR points at the null
    public abstract void remove_all(T value);
    //POST: there are no elements equal to value in the list

    public abstract void add_to_empty(T value);
    //POST: head and tail points at the node with T value, size of the list is 1


    //REQUESTS:
    public abstract T get();
    public abstract void size();

    public abstract Boolean is_head();
    public abstract Boolean is_tail();
    public abstract Boolean is_value();

    public abstract int get_put_right_status(); // return PUT_RIGHT* status
    public abstract int get_right_status(); // return RIGHT* status
    public abstract int get_method_status(); // return GET* status
    public abstract int get_remove_status(); // return REMOVE* status

    // 2.2 tail не сводима к другим операциям, так как предполагает сразу указывать на последний элемент - в противном случае,
    // пришлось бы использовать цикл и комбинацию из вызовов right(), что неэффективно

    // 2.3 Операция поиска всех узлов с заданным значением уже не нужна, так как можно использовать комбинацию find() и right()
}
