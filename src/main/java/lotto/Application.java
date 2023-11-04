package lotto;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        final int buycount = numbergenerator.createUnitLotto(10000);
        System.out.println(buycount);
    }
}
