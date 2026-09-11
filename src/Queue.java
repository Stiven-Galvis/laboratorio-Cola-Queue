public class Queue {
    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.isPriorityQueue = false;
    }

    public Queue(boolean isPriorityQueue) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.isPriorityQueue = isPriorityQueue;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(Object object) {
        enqueue(object, 0);
    }

    public void enqueue(Object object, int priority) {
        QueueNode newNode = new QueueNode(object, priority) ;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (isPriorityQueue) {
            if (priority > head.priority) {
                newNode.next = head;
                head = newNode;
            } else {
                QueueNode current = head;
                while (current.next != null && current.next.priority >= priority) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
            }
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object object = head.object;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return object;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return head.object;
    }
}