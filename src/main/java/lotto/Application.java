package lotto;

public class Application {
    LotterySystem lottery = new LotterySystem();
    public static void main(String[] args) {
        LotterySystem lottery = new LotterySystem();

        try {
//            InputSystem.isRangeValid("56");
            lottery.input();
            lottery.draw();
            lottery.getNumbers();
            lottery.bonus();
        } catch (Exception e) {
            System.out.println("[ERROR]");
        }
    }

}
