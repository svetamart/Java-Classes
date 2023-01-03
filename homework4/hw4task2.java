import java.util.LinkedList;
import java.util.Random;

// Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class hw4task2 {
    public static void main (String[] args) {

        MyQueue q = new MyQueue();
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(23);
        q.enqueue(42);

        System.out.println(q);
        System.out.println(q.first());
        System.out.println(q.dequeue());
        System.out.println(q);

    }
}
