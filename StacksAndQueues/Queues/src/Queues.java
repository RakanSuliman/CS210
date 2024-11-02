public class Queues {
    private int size;
    private int[] queue;
    private int front;
    private int currentSize;
    private int rear;

    public Queues(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.currentSize = 0;
    }
    public int size(){
        return currentSize;
    }

    public void enqueue(int item) {
        if (currentSize == size) {
            System.out.println("Queue is full");
            return;
        }
        int N = (front+currentSize)%size;
        queue[N] = item;
        currentSize++;
    }
    public int dequeue() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = queue[front];
        front = (front + 1)%size;
        currentSize--;

        return temp;


    }
    public int top() {
     if (isEmpty()){
         System.out.println("Queue is empty");
         return -1;
     }
        return queue[front];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }

}
