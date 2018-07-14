package stream.Chapter4;

import java.util.Scanner;

public class TestFunctionalInterface {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        TriFunction<Double, Integer, Integer, Double> calcCost = (cost, tipPct, taxPcnt) ->
                (cost + (cost * tipPct/100) + (cost * taxPcnt/100));
        Double totalBill = calculation(calcCost, mealCost, tipPercent, taxPercent);
        System.out.println(totalBill);
    }

    public static Double calculation(TriFunction<Double, Integer, Integer, Double> calcCost ,
                                     Double mealCost, Integer tipPct, Integer taxPct) {
        return calcCost.apply(mealCost, tipPct, taxPct);
    }
}

@FunctionalInterface
interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}

