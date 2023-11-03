package lotto;

public class Controller {

    private static final Integer LOTTERY_PRICE = 1_000;
    public static Integer calculateLotteryCount(Integer budget) {
        return budget / LOTTERY_PRICE;
    }
}
