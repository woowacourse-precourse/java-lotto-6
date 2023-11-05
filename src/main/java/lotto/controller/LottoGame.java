package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputUtil;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoService lottoService = new LottoService();
    private final HashMap<Rank, Integer> result = new HashMap<>();
    private long payment;
    private Buyer buyer;
    private WinningLotto winningLotto;
    private long reward;
    public void run() {
        buyLotto();
        initWinningLotto(inputWinningLotto(), inputBonusNumber());
        initResult();
        matchLottos();
//        showResult();
    }

    private List<Integer> inputWinningLotto() {
        InputView.inputNumbers();
        return LottoUtils.stringToList(InputUtil.inputStringWithTrim());
    }

    private String inputBonusNumber() {
        InputView.inputBonusNumber();
        return InputUtil.inputStringWithTrim();
    }

    private void initWinningLotto(List<Integer> lotto, String bonus) {
        winningLotto = new WinningLotto(lotto, bonus);
    }

    private Long lottoPayment() {
        return payment = Long.parseLong(amountValidation(InputUtil.inputStringWithTrim()));
    }

    private String amountValidation(String amount) {
        Validation.checkIsNumber(amount);
        Validation.checkIsNatural(Integer.parseInt(amount));
        Validation.checkIsDivideByThousand(amount);
        return amount;
    }

    private void buyLotto() {
        InputView.inputPrise();
        buyer = new Buyer(lottoPayment());
        buyer.showLottos();
    }

    private void matchLottos() {
        for (Lotto lotto : buyer.getLottos()) {
            int cnt = LottoUtils.matchLotto(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatch = LottoUtils.matchBonus(cnt, lotto, winningLotto.getBonus());
            countResult(cnt, bonusMatch);
        }
    }

    private void countResult(int cnt, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (!isCorrect(rank, cnt, bonusMatch)) {
                continue;
            }
            reward = rank.calculateReward(reward);
            result.put(rank, result.get(rank) + 1);
        }
    }

    private boolean isCorrect(Rank rank, int num, boolean bonus) {
        return rank.getMatchNumbers() == num && rank.getMatchBonus() == bonus;
    }

    private void initResult() {
        reward = 0;
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }
}
