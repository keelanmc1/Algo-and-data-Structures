public interface StackInterface <T>
{

    public void push (T newEntry);
    //add a new entry to the top of the stack

    public T pop();
    //removes and returns the top entry from the stack
    //throws empty stack exception if called on an empty stack

    public T peek();
    //returns but doesnt remove the entry at the top of the stack
    //it also throws EmptyStackException if called on an empty stack

    public boolean isEmpty();
    //returns true if the stack is empty, otherwise it returns false

    public void clear();
    //removes all entries from the stack

}