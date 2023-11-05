package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.policy.LottoPolicy;
import lotto.policy.WinConditionPolicy;
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

    public int getWinNumberCount(Lotto userLotto, Lotto winLottoNumber) {
        return (int) userLotto.getNumbers().stream()
                .filter(number -> winLottoNumber.contains(number))
                .count();
    }

    public int getBonusNumberCount(Lotto userLotto, int bonusLottoNumber) {
        if (userLotto.contains(bonusLottoNumber)) {
            return 1;
        }
        return 0;
    }

    public void makeResults(List<WinConditionPolicy> results, int winNumberCount, int bonusNumberCount) {
        for (WinConditionPolicy winConditionPolicy : WinConditionPolicy.values()) {
            WinConditionPolicy result = winConditionPolicy.getMatchWith(winNumberCount, bonusNumberCount);
            addResultWhenNotNull(results, result);
        }
    }

    private void addResultWhenNotNull(List<WinConditionPolicy> results, WinConditionPolicy result) {
        if (results != null) {
            results.add(result);
        }
    }
}
