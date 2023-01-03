import java.util.LinkedList;

public class MyQueue {
    LinkedList<Integer> list = new LinkedList<>();

    //enqueue() - помещает элемент в конец очереди
    public void enqueue(int number) {
        list.addLast(number);
    }

    // dequeue() - возвращает первый элемент из очереди и удаляет его

    public int dequeue() {

        int temp = list.getFirst();
        list.pollFirst();

        return temp;

    }

    // first() - возвращает первый элемент из очереди, не удаляя
    public int first() {
        return list.getFirst();
        }

    @Override
    public String toString() {
        return list.toString();
    }
}

