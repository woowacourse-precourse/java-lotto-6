package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.policy.LottoPolicy;
import lotto.util.LottoProvider;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    public User createUserLotto(int purchase) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoAmount = LottoPolicy.LOTTO_AMOUNT.getValue();
        int lottoCount = purchase / lottoAmount;
        while (lottoCount-- > 0) {
            lottos.add(LottoProvider.createLotto());
        }
        return new User(lottos);
    }

    public void listPurchaseLotto(User user) {
        outputView.printPurchaseLotto(user);
    }

    public Lotto getWinLottoNumber() {
        List<Integer> winNumbers = inputView.inputWinNumber();
        return new Lotto(winNumbers);
    }

    public int getBonusLottoNumber(Lotto winNumber) {
        return inputView.inputBonusNumber(winNumber);
    }
}
