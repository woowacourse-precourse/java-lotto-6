package lotto;

import lotto.controller.Controller;
import lotto.exception.handler.ExceptionHandler;
import lotto.model.Lotto;
import lotto.view.View;

import java.util.HashMap;
import java.util.List;

public class Application {

    private final View view = new View();
    private final Controller controller = new Controller();
    private final ExceptionHandler handler = new ExceptionHandler();


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();

    }

    void run() {
        try {
            int price = view.getPrice();
            List<Lotto> lotteries = controller.buyLotteries(price);
            view.printBoughtLotteries(lotteries);
            Lotto winner = view.getWinnerLottery();
            int bonusNumber = view.getBonusNumber();
            HashMap<String, Integer> lotteryResult = controller.getLotteryResult(lotteries, winner, bonusNumber);
            view.printLotteryResult(lotteryResult);
        } catch (Exception e) {
            handler.handleException(e);
        }
    }
}
