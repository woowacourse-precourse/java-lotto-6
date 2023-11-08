package lotto;

import lotto.config.Configuration;

public class Application {
    private static final String username = "user0";

    public static void main(String[] args) {
        Controller controller = Configuration.getController(username);

        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();
    }
}
