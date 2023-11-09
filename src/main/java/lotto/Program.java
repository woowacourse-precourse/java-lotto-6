package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BroadCastingStation;
import lotto.domain.Calculator;
import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.Store;
import lotto.error.LottoErrorMessage;

public class Program {
    private List<Lotto> consumerLottos = null;
    private Lotto winning = null;
    private LottoDrawResult drawResult = null;

    public void purchaseLottos() {
        Integer payment = 0;
        List<Lotto> lottos = null;
        while (true) {
            try {
                payment = UI.inputMoney();
                lottos = Store.sellLottos(payment);
                UI.printPurchases(lottos);
            } catch (IllegalArgumentException e) {
                UI.printExceptionCause(e);
                continue;
            }
            break;
        }
        this.consumerLottos = lottos;
    }

    public void insertWinningNumbers() {
        Lotto winning = null;
        while (true) {
            try {
                validateInsertLottoState();
                List<Integer> winningNumbers = UI.inputWinningNumbers();
                winning = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                UI.printExceptionCause(e);
                continue;
            }
            break;
        }
        this.winning = winning;
    }

    public void insertBonusNumber() {
        Integer bonus = null;
        while (true) {
            try {
                validateInsertWinningNumbersState();
                bonus = UI.inputBonusNumber();
                drawResult = BroadCastingStation.drawLotto(winning, bonus);
            } catch (IllegalArgumentException e) {
                UI.printExceptionCause(e);
                continue;
            }
            break;
        }
    }

    public void showResult() {
        try {
            validateShowState();
        } catch (IllegalStateException e) {
            UI.printExceptionCause(e);
            return;
        }
        Map<Grade, Integer> winningFrequency = obtainWinningFrequency(consumerLottos, drawResult);
        Double returnRate = Calculator.returnRate(consumerLottos, drawResult);
        UI.printWinningStats(winningFrequency, returnRate);
    }

    private Map<Grade, Integer> obtainWinningFrequency(List<Lotto> lottos, LottoDrawResult lottoDrawResult) {
        Map<Grade, Integer> winningFrequency = new HashMap<>();
        initializeWinningFrequency(winningFrequency);

        for (Lotto lotto : lottos) {
            Grade grade = Calculator.checkWinning(lotto, lottoDrawResult);
            if (grade == Grade.NONE) {
                continue;
            }
            Integer frequency = winningFrequency.get(grade);
            winningFrequency.put(grade, frequency + 1);
        }
        return winningFrequency;
    }

    private void initializeWinningFrequency(Map<Grade, Integer> winningFrequency) {
        winningFrequency.put(Grade.FIRST, 0);
        winningFrequency.put(Grade.SECOND, 0);
        winningFrequency.put(Grade.THIRD, 0);
        winningFrequency.put(Grade.FOURTH, 0);
        winningFrequency.put(Grade.FIFTH, 0);
    }

    private void validateInsertLottoState() {
        if (consumerLottos == null) {
            throw new IllegalStateException(LottoErrorMessage.SETTING_PURCHASE);
        }
    }

    private void validateInsertWinningNumbersState() {
        if (winning == null) {
            throw new IllegalStateException(LottoErrorMessage.SETTING_WINNING);
        }
    }

    private void validateShowState() {
        if (drawResult == null) {
            throw new IllegalStateException(LottoErrorMessage.SETTING_BONUS);
        }
    }
}