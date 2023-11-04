package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.policy.LottoPolicy;
import lotto.view.InputView;

public class Controller {
    private final InputView inputView;

    public Controller() {
        this.inputView = new InputView();
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
}
