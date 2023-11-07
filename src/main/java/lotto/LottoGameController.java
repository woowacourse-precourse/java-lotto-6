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

        NumberGenerator numberGenerator = appConfig.numberGenerator();
        Lottos lottos = new Lottos();
        while (purchased > 0) {
            Lotto lotto = numberGenerator.generate();
            if (!lottos.contain(lotto)) {
                lottos.add(lotto);
                OutputView.printPurchasedLottos(LottoDto.from(lotto));
                purchased--;
            }
        }

        InputView inputView = appConfig.inputView();
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        Lotto lotto = new Lotto(winningNumbers);
    }

    public Money getMoney() {
        InputView inputView = appConfig.inputView();
        return inputView.getMoney();
    }

}
