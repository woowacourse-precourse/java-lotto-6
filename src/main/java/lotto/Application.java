package lotto;

public class Application {
    public static void main(String[] args) {
        LotterySystem lottery = new LotterySystem();
        try {
            lottery.input();
            lottery.draw();
            lottery.getNumbers();
            lottery.bonus();
            lottery.perform();
            lottery.result();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
