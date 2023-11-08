package lotto;

import lotto.domain.Customer;
import lotto.domain.Game;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer(InputView.inputBuyMoney());
        customer.showMyLotto();

        Game game = new Game(customer);
        game.createWinningNum(InputView.inputWinningNum());
        game.createBonusNum(InputView.inputBonusNum());

        game.checkResult();
        game.showStatistics();
    }
}
