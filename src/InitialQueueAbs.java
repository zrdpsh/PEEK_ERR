package src;

public abstract class InitialQueueAbs<T> {

    // CONSTRUCTOR:
    public InitialQueueAbs() {

    }

    // COMMANDS:

    public abstract void enqueue(T item);
    // POST: new element added to the end of the queue

    public abstract void dequeue();
    // POST: the element first added is removed from the queue


    // REQUESTS:

    public abstract T getItem();
    public abstract int size();

    public abstract int get_dequeue_status();

    public abstract int get_getItem_status();
}
