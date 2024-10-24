import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        // Runnable to add elements to the list
        Runnable adder = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        // Runnable to remove elements from the list
        Runnable remover = () -> {
            for (int i = 0; i < 1000; i++) {
                if (!list.isEmpty()) {
                    list.remove(0);
                }
            }
        };

        Thread thread1 = new Thread(adder);
        Thread thread2 = new Thread(remover);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final list size: " + list.size());
    }
}
