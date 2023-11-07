package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.User;
import lotto.service.LottoGenerateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerateService lottoGenerateService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerateService = new LottoGenerateService(outputView);
    }

    public void start() {
        Money money = getMoney();
        outputView.showNumberOfLotto(money);
        Lottos lottos = lottoGenerateService.makeLotto(money);
        Lotto userLotto = getLotto();
        User user = getBonus(userLotto);
        outputView.showLottoStatistics(lottos, user, money);
    }

    private Money getMoney() {
        try {
            return new Money(inputView.inputPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private Lotto getLotto() {
        try {
            String inputLotto = inputView.inputLottoNumber();
            return new Lotto(inputLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLotto();
        }
    }

    private User getBonus(Lotto userLotto) {
        try {
            String inputBonus = inputView.inputBonusNumber();
            return new User(userLotto, inputBonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonus(userLotto);
        }
    }

}
