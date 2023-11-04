package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoPurchase lottoPurchase = new LottoPurchase();

        int userPurchase = lottoPurchase.inputLottoPurchase();
        System.out.printf("\n%d개를 구매하셨습니다.\n",userPurchase);

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateRandomNumber(userPurchase);
    }
}
