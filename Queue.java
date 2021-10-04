public class Queue <T> implements QueueInterface<T>
{
    private MyNode<T> front, rear;

    public Queue()
    {
        front = null ;
        rear = null;
    }
    public void enQueue(T newEntry)
    {
        MyNode<T> node = new MyNode<T>(newEntry);
        if(front==null)
        {
            front=node;
            rear=node;
        }

        else
        {
            rear.setNext(node);
            rear=node;
        }
    }

    public T deQueue()
    {
        if(front==null) return null;

        else{
            T valueToReturn = front.getData();
            front = front.getNext();
            if(front == null) rear = null;
            return valueToReturn;
        }


    }

    public T getFront()
    {
        if(front ==null) return null;

        else
        {
            return front.getData();
        }
    }
    //returns the item at the from of the queue without removing it from the queue

    public boolean isEmpty()
    {
        return (rear ==null);
    }

    public void clear()
    {
        front=null;
        rear = null;
    }

    public static void main(String[]args)
    {
        Queue<String> q = new Queue<String>();

        q.enQueue("Keelan");
        q.enQueue("katie");

       System.out.println(q.getFront()) ;
       q.deQueue();
        System.out.println(q.getFront()) ;
    }
}
