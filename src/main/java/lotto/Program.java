package lotto;

import java.util.List;
import lotto.constant.LottoErrorMessage;
import lotto.domain.BroadCastingStation;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.domain.Store;

public class Program {
    private List<Lotto> consumerLottos = null;
    private Lotto winning = null;
    private Integer bonus = null;

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
                bonus = UI.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                UI.printExceptionCause(e);
                continue;
            }
            break;
        }
        this.bonus = bonus;
    }

    public void showResult() {
        try {
            validateShowState();
        } catch (IllegalStateException e) {
            UI.printExceptionCause(e);
            return;
        }
        LottoDrawResult drawResult = BroadCastingStation.drawLotto(winning, bonus);
        UI.printWinningStats(consumerLottos, drawResult);
    }

    private void validateShowState() {
        if (consumerLottos == null || winning == null || bonus == null) {
            throw new IllegalStateException(LottoErrorMessage.SETTING_SEQUENCE);
        }
    }
}