package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.config.AppConfig;
import lotto.utils.NumberGenerator;

public class LottoGameController {

    private final AppConfig appConfig;

    public LottoGameController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void run() {
        Money money = getMoney();
        LottoPurchaser lottoPurchaser = new LottoPurchaser(money);
        int purchased = lottoPurchaser.purchase();
        OutputView outputView = appConfig.outputView();
        outputView.printPurchasedLottoSize(purchased);
    }

    public Money getMoney() {
        InputView inputView = appConfig.inputView();
        return inputView.getMoney();
    }

}
