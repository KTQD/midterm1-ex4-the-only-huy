public class Main {

    private static final int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

    public static void main(String[] args) throws InterruptedException, NumberFormatException {

        Thread sumThread = new Thread(new SumTask());
        Thread maxThread = new Thread(new MaxTask());


        sumThread.start();
        maxThread.start();


        sumThread.join();
        maxThread.join();


        System.out.println("Tổng của các phần tử trong mảng là: " + SumTask.sum);
        System.out.println("Phần tử lớn nhất trong mảng là: " + MaxTask.max);
    }

    private static class SumTask implements Runnable {
        private static int sum = 0;
        public void run() {
            for (int number : numbers) {
                sum += number;
            }
        }
    }

    private static class MaxTask implements Runnable {
        private static int max = -100000;
        public void run() {
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
        }
    }
}
