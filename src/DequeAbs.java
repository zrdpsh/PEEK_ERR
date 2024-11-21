package src;

import src.InitialQueueAbs;

public abstract class DequeAbs<T> extends InitialQueue<T> {

    // CONSTRUCTOR:
    public DequeAbs() {
        // constructor
    }

    // COMMANDS:

    public abstract void enqueue(T item);
    // POST: new element added to the beginning of the queue

    public abstract void dequeue();
    // POST: the element first added is removed from the queue


    // REQUESTS:

    public abstract int dequeue_status();
}
