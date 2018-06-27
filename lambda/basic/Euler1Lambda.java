package basic;
import java.util.function.IntPredicate;
import java.util.logging.Logger;

/**
 * sum all numbers if(n % 3 == 0 || n % 5 == 0).
 */

 class Euler1Lambda {
    private long max;
     private Euler1Lambda(long max) {
        this.max = max;
    }
    private static boolean div3remainder0(int number) {
        return number % 3 == 0;
    }

    private static boolean div5remainder0(int number) {
        return number % 5 == 0;
    }

    private long sumAll() {
        long sum = 0;
        for(int i=1; i<max; i++) {
            if (div3remainder0(i) ||div5remainder0(i)) {
                sum += i;
            }
        }
        return sum;
    }


    /**
     *
     * @param p
     *          pass a lambda expression   n->div3remainder0(n) ||div5remainder0(n);
     * @return total
     */
    private long sumAllLambda(IntPredicate p) {
        long total = 0;
        for (int i = 1; i< max; i++){
            if (p.test(i)) {
                total += i;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        //normal expression
        long startTime = System.currentTimeMillis();
        //Logger.getGlobal().info("Starting time is "+startTime);
        for(int i = 0; i < 10; i++){
            new Euler1Lambda(10000000).sumAll();
        }
        long endTime = System.currentTimeMillis();
        //Logger.getGlobal().info("Ending time is "+ endTime);
        long conv = (endTime - startTime);
        Logger.getGlobal().info("Total execution time: " + conv);
        //lambda
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            new Euler1Lambda(10000000).sumAllLambda(n -> div3remainder0(n) || div5remainder0(n));
        }
        endTime = System.currentTimeMillis();
        long lambda = (endTime - startTime);
        Logger.getGlobal().info("Total execution time: " + lambda);
        System.out.println("lambda / conv : " + (float)lambda/conv);
    }
}