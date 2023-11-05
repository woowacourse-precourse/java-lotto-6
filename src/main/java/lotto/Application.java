package lotto;

import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(new InputInterface(), new OutputInterface());
        controller.purchaseLotteries();
        controller.drawWinningLottery();
        System.out.println(OUTPUT_LOTTERY_RESULT);
    }
}
