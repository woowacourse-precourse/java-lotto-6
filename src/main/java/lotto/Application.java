package lotto;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numbergenerator = new NumberGenerator();
        final int num = numbergenerator.inputBuyCost();
        System.out.println(num);
    }
}
