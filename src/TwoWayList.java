package src;

public class TwoWayList<T> extends LinkedList<T> {
    public final int LEFT_NIL = 0; // left method hasn't been evoked yet
    public final int LEFT_OK = 1; // last left() has run correctly
    public final int LEFT_ERR = 2; // cursor points at null element - error


    private int leftStatus;


    @Override
    public ParentListAbs<T> ParentListAbs() {
        leftStatus = LEFT_NIL;
        return null;
    }


    @Override
    public void left() {
        if (current != null && current.prev != null) {
            current = current.prev;
            leftStatus = LEFT_OK;
            return;
        }
        leftStatus = LEFT_ERR;
    }


    @Override
    public int get_left_status() {
        return leftStatus;
    }
}
