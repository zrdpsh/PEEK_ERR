package src;
import java.util.LinkedList;

public  class Deque<T> extends DequeAbs<T> {

    public final int ENQUEUE_STATUS_NIL= 0; // dequeue method has run correctly
    public final int ENQUEUE_STATUS_OK = 1; // dequeue method has run correctly
    public final int ENQUEUE_STATUS_ERR = 2; // dequeue method has run correctly

    public final int DEQUEUE_STATUS_NIL= 0; // dequeue method has run correctly
    public final int DEQUEUE_STATUS_OK = 1; // dequeue method has run correctly
    public final int DEQUEUE_STATUS_ERR = 2; // dequeue method has run correctly

    private int dequeue_status;
    private int enqueue_status;

    protected T item;
    protected LinkedList<T> linkedList;

    public Deque() {
        super();
        dequeue_status = DEQUEUE_STATUS_NIL;
        enqueue_status = ENQUEUE_STATUS_NIL;
    }

    @Override
    public void enqueue(T item) {
        linkedList.addFirst(item);
    }

    @Override
    public void dequeue() {
        item = linkedList.pollLast();
        if (item != null) {
            dequeue_status = DEQUEUE_STATUS_OK;
            return;
        }
        dequeue_status = DEQUEUE_STATUS_ERR;
    }

    @Override
    public int dequeue_status() {
        return dequeue_status;
    }

}
