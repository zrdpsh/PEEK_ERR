package src;
import java.util.LinkedList;

public class InitialQueue<T> extends InitialQueueAbs<T> {

    public final int DEQUEUE_NIL = 0; // removeFront hasn't been evoked yet
    public final int DEQUEUE_OK = 1; // removeFront method has run correctly
    public final int DEQUEUE_ERR = 2; // removeFront method hasn't run correctly

    public final int GET_ITEM_NIL = 0; // getItem hasn't been evoked yet
    public final int GET_ITEM_OK = 1; // getItem method has run correctly

    private int dequeue_status;
    private int getStatus;
    protected T item;
    protected LinkedList<T> linkedList;

    public InitialQueue() {
        linkedList = new LinkedList<>();
        dequeue_status = DEQUEUE_NIL;
        getStatus = GET_ITEM_NIL;
    }

    @Override
    public void enqueue(T item) {
        linkedList.addLast(item);
    }

    @Override
    public void dequeue() {
        item = linkedList.pollFirst();
        if (item != null) {
            dequeue_status = DEQUEUE_OK;
          return;
        }
        dequeue_status = DEQUEUE_ERR;
    }

    @Override
    public T getItem() {
        getStatus = GET_ITEM_OK;
        return item;
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public int get_dequeue_status() {
        return dequeue_status;
    }

    @Override
    public int get_getItem_status() {
        return getStatus;
    }

}
