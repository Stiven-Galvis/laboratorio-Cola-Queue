public class QueueNode {
    Object object;
    int priority;
    QueueNode next;

    public QueueNode(Object object, int priority) {
        this.object = object;
        this.priority = 0;
        this.next = null;
    }

    public QueueNode() {
        this.object = object;
        this.priority = priority;
        this.next = null;
    }
}