public interface QueueInterface <T>
{
    public void enQueue(T newEntry);
    //adds a new entry to the queue

    public T deQueue();
    //takes an entry out of the queue

    public T getFront();
    //returns the item at the from of the queue without removing it from the queue

    public boolean isEmpty();
    //returns true if the queue is empty, otherwise returns false

    public void clear();
    //empties all the items within the queue
}