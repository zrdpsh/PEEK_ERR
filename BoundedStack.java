import java.util.ArrayList;
import java.util.List;


/*
class BoundedStack<T> {
    const POP_NIL = 0; // push hasn't been evoked yet
    const POP_OK = 1; // last pop() worked correctly
    const POP_ERR = 2; // stack is empty

    const PEEK_NIL = 0; // push hasn't been evoked yet
    const PEEK_OK = 1; // last pop() worked correctly
    const PEEK_ERR = 2; // stack is empty

    const PUSH_OK = 0; // new element added
    const PUSH_ERR = 1; // stack is full


    CONSTRUCTOR:
    public BoundedStack<T> BoundedStack();
    // POST: new stack of fixed length is created

    COMMANDS:
    // PRE: stack isn't full
    public void push(T value);
    // POST: new element added into the stack OR stack is full

    // PRE: stack isn't empty;
    public void pop();
    // POST: the top element is removed from the stack

    public void clear();
    // POST: stack is empty


    REQUESTS:
    // PRE: stack isn't empty
    public T peek();

    public int size();


    ADDITIONAL REQUESTS:
    public int get_pop_status(); // return POP_* value
    public int get_peek_status(); // return PEEK_* value
    public int get_push_status(); // return PUSH_* value
}
 */

public class BoundedStack<T> {

    private ArrayList<T> stack;

    private int stack_size;
    private int top_element_index = 0;

    private int peek_status;
    private int pop_status;
    private int push_status;

    public final int POP_NIL = 0; // push hasn't been evoked yet
    public final int POP_OK = 1; // last pop() worked correctly
    public final int POP_ERR = 2; // stack is empty

    public final int PEEK_NIL = 0; // push hasn't been evoked yet
    public final int PEEK_OK = 1; // last pop() worked correctly
    public final int PEEK_ERR = 2; // stack is empty

    public final int PUSH_OK = 0; // last push() worked correctly
    public final int PUSH_ERR = 1; // stack is full

    public final int DEFAULT_STACK_SIZE = 32;



    public void Stack() {
        stack = new ArrayList<>();
        stack_size = DEFAULT_STACK_SIZE;
    }

    public void Stack(int size) {
        stack = new ArrayList<>();
        stack_size = size;
    }

    // PRE: stack isn't full
    public void push(T value) {
        if (top_element_index == stack_size) {
            push_status = PUSH_ERR;
            return;
        }

        stack.add(value);
        top_element_index += 1;
        push_status = PUSH_OK;
    }
    // POST: new element added into the stack OR stack is full


    // PRE: stack isn't empty
    public void pop() {
        if (size() > 0) {
            stack.remove(top_element_index-1);
            top_element_index -= 1;
            pop_status = POP_OK;
            return;
        }
        pop_status = POP_ERR;
    }
    // POST: the last element is removed from the stack



    public void clear() {
        stack = new ArrayList<>();
        peek_status = PEEK_NIL;
        pop_status = POP_NIL;
    }
    // POST: all elements are removed from the stack




    // peek PRECONDITION: stack isn't empty
    public T peek() {
        if (size() > 0) {
            T result = stack.get(stack_size-1);
            peek_status = PEEK_OK;
            return result;
        }
        T result = (T) new Object();
        peek_status = PEEK_ERR;
        return result;
    }

    public int size() {
        return stack.size();
    }

    public int get_pop_status() {
        return pop_status;
    }

    public int get_pop_status() {
        return peek_status;
    }

    public int get_push_status() {
        return push_status;
    }
}
