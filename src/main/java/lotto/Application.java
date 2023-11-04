package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoPurchase lottoPurchase = new LottoPurchase();

        int userPurchase = lottoPurchase.inputLottoPurchase();
        System.out.println(userPurchase);
    }
}
