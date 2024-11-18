package src;

public abstract class QueueAbs<T> {

        public final int ENQUEUE_NIL = 0; // enqueue hasn't been evoked yet
    public final int ENQUEUE_OK = 1; // enqueue method has run correctly

    public final int DEQUEUE_NIL = 0; // dequeue hasn't been evoked yet
    public final int DEQUEUE_OK = 1; // dequeue method has run correctly

    public abstract void enqueue(T item);
    // POST: new element added to the end of the queue

    public abstract T dequeue();
    // POST: from the list removed the most early added element

    //REQUESTS:
    public abstract int size();

    public abstract int get_enqueue_status();
    public abstract int get_dequeue_status();


}
