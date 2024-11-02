public class Stacks {
    private int top;
    private int[] stack;
    private int size;
    private int currentsize;

    public Stacks(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
        this.currentsize = 0;
    }
    public void push(int value) {
     if (top == size - 1) {
         System.out.println("Stack is full");
        return;
     }
        stack[++top] = value;
        currentsize++;
    }
    public int pop() {
        if (top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        currentsize--;
        return stack[top--] ;
    }
    public int front(){
        if (top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return currentsize;
    }
}
