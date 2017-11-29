package logger;

public class SysoTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println("syso打印1" + i);
            System.out.println("syso打印2" + i);
            System.out.println("syso打印3" + i);
        }

        long time = System.currentTimeMillis() - start;
        System.out.println(time);
    }
}
