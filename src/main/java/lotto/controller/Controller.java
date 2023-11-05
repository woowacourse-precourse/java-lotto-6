package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.policy.LottoPolicy;
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
        while (purchase >= lottoAmount) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoPolicy.MIN_LOTTO_NUMBER.getValue(),
                    LottoPolicy.MAX_LOTTO_NUMBER.getValue(),
                    LottoPolicy.LOTTO_NUMBER_COUNT.getValue()
            );
            lottos.add(new Lotto(numbers));
            purchase -= lottoAmount;
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
