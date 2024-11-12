package src;

public class ParentList<T> extends ParentListAbs<T> {

    protected Node<T> current;
    protected Node<T> head;
    protected Node<T> tail;
    private int size;
    private int headStatus;
    private int tailStatus;
    private int putRightStatus;
    private int putLeftStatus;
    private int rightStatus;
    private int removeStatus;
    private int replaceStatus;
    private int findStatus;
    private int getStatus;




    @Override
    public ParentListAbs<T> ParentListAbs() {
        headStatus = HEAD_NIL;
        tailStatus = TAIL_NIL;
        putRightStatus = PUT_RIGHT_NIL;
        putLeftStatus = PUT_LEFT_NIL;
        rightStatus = RIGHT_NIL;
        removeStatus = REMOVE_NIL;
        replaceStatus = REPLACE_NIL;
        findStatus = FIND_NIL;
        getStatus = GET_NIL;
        return null;
    }

    @Override
    public void head() {
        current = head;
    }

    @Override
    public void tail() {
        current = tail;
    }

    @Override
    public void put_right(T value) {
        Node<T> nextNode = current;
        Node<T> newNode = new Node<T>(value);
        insertNode(nextNode, newNode);
        putRightStatus = PUT_RIGHT_OK;
        size++;
    }

    @Override
    public void put_left(T value) {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
        Node<T> nextNode = current;
        Node<T> newNode = new Node<T>(value);
        insertNode(nextNode, newNode);
        putLeftStatus = PUT_LEFT_OK;
        size++;
    }

    @Override
    public void right() {
        if (current != null && current.next != null) {
            current = current.next;
            rightStatus = RIGHT_OK;
            return;
        }
        rightStatus = RIGHT_ERR;
    }

    @Override
    public void left() {

    }

    @Override
    public void remove() {
        Node<T> node = current;
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (is_head()) {
                if (node.next != null) {
                    this.head = node.next;
                    this.head.prev = null;
                } else {
                    this.head = null;
                }
            }
            if (is_tail()) {
                if (node.prev != null) {
                    this.tail = node.prev;
                    this.tail.next = null;
                } else {
                    this.tail = null;
                }
            }
            removeStatus = REMOVE_OK;
            size--;
        }
        removeStatus = REMOVE_ERR;
    }

    @Override
    public void clear() {
        current = null;
        head = null;
        tail = null;
        size = 0;
    }

    public void add_tail(T value) {
        Node<T> addedNode = new Node<T>(value);
        if (head == null) {
            this.head = addedNode;
            this.head.next = null;
            this.head.prev = null;
        }
        if (head != null){
            this.tail.next = addedNode;
            addedNode.prev = tail;
        }
        this.tail = addedNode;
    }

    @Override
    public void replace(T value) {
        Node<T> tempPrev = current.prev;
        Node<T> tempNext = current.next;
        Node<T> addedNode = new Node<T>(value);
        current = addedNode;
        current.prev = tempPrev;
        current.next = tempNext;
    }

    @Override
    public void find(T value) {
        Node<T> node = this.head;
        while (node != null) {
            if(node.value.equals(value)) {
                current = node;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public void remove_all(T value) {
        find(value);
        Node<T> node = current;
        while (node != null) {
            remove();
            find(value);
            node = current;
        }
    }


    @Override
    public T get() {
        if (current != null) {
            getStatus = GET_OK;
            return current.value;
        }
        getStatus = GET_OK;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Boolean is_head() {
        return head.equals(current);
    }

    @Override
    public Boolean is_tail() {
        return tail.equals(current);
    }

    @Override
    public Boolean is_value() {
        return current != null;
    }

    @Override
    public int get_head_status() {
        return headStatus;
    }

    @Override
    public int get_tail_status() {
        return tailStatus;
    }

    @Override
    public int get_right_status() {
        return rightStatus;
    }

    @Override
    public int get_left_status() {
        return 0;
    }

    @Override
    public int get_put_right_status() {
        return putRightStatus;
    }

    @Override
    public int get_put_left_status() {
        return putLeftStatus;
    }

    @Override
    public int get_remove_status() {
        return removeStatus;
    }

    @Override
    public int get_replace_status() {
        return replaceStatus;
    }

    @Override
    public int get_find_status() {
        return findStatus;
    }

    @Override
    public int get_get_status() {
        return getStatus;
    }


    private void insertNode(Node<T> nextNode, Node<T> newNode) {
        if (this.size() > 0) {
            if (is_tail()) {
                Node<T> oldTail = this.tail;
                this.tail = newNode;
                this.tail.prev = oldTail;
            }
            if (nextNode != null) {
                Node<T> nodeAfterNext = nextNode.next;
                if (nodeAfterNext != null) {
                    nodeAfterNext.prev = newNode;
                }
                newNode.next = nodeAfterNext;
                newNode.prev = nextNode;
                nextNode.next = newNode;
            } else {
                Node<T> oldHead = this.head;
                newNode.next = oldHead;
                oldHead.prev = newNode;
                this.head = newNode;
            }
        } else {
            if (head == null) {
                this.head = newNode;
                this.head.next = null;
                this.head.prev = null;
            } else {
                this.tail.next = newNode;
                newNode.prev = tail;
            }
            this.tail = newNode;
        }
    }
}
