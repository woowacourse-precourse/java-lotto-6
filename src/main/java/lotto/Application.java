package lotto;

public class Application {
    LotterySystem lottery = new LotterySystem();
    public static void main(String[] args) {
        LotterySystem lottery = new LotterySystem();

        try {
            lottery.input();
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }

    }

}
