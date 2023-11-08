package lotto.controller;

import static lotto.utils.InputErrorHandler.*;

import java.util.List;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lottomachine.RandomLottoMachine;
import lotto.domain.shop.Shop;
import lotto.domain.user.User;
import lotto.dto.WinningResult;
import lotto.utils.InputErrorHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller (InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        User user = new User();
        Shop shop = new Shop(new RandomLottoMachine());
        buyLotto(user, shop);
        outputView.printLottoOrder(user.getLottos());
        drawWinningLotto(shop);
        shop.checkUserResult(user);
        outputView.printLottoStats(WinningResult.from(user));
    }

    private void drawWinningLotto(Shop shop) {
        printErrorMessageAndRetry(() -> {
            List<Integer> winningNumbers = inputView.InputWinningNumbers();
            Integer bonusNumber = inputView.InputBonusNumber();
            shop.drawWinningLotto(winningNumbers, bonusNumber);
        });
    }

    private void buyLotto(User user, Shop shop) {
        printErrorMessageAndRetry(() -> {
            int price = inputView.inputPurchaseAmount();
            user.buyLotto(price, shop);
        });
    }
}
