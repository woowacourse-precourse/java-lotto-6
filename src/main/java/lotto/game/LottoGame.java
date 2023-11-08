package lotto.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoGameNumber;
import lotto.model.Lotto;
import lotto.util.LottoGameConsole;
import lotto.util.LottoGenerator;

public class LottoGame {
    private int cost = Integer.MIN_VALUE;
    private int bonusNumber = Integer.MIN_VALUE;
    private Lotto target;
    private List<Lotto> lottos;

    public void initCost() {
        while (cost == Integer.MIN_VALUE) {
            readCost();
        }
    }

    public void initTarget() {
        while (Objects.isNull(target)) {
            readTarget();
        }
    }

    public void initBonusNumber() {
        while (bonusNumber == Integer.MIN_VALUE) {
            readBonusNumber();
        }
    }

    public void purchaseLottos() {
        int count = cost / LottoGameNumber.COST_UNIT;

        lottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }

        lottos = lottos.stream()
                .toList();

        LottoGameConsole.printPurchaseLottos(lottos);
    }

    private void readCost() {
        try {
            cost = LottoGameConsole.readCost();
        } catch (NumberFormatException e) {
            LottoGameConsole.printError(LottoGameMessage.NON_NUMBER);
        } catch (IllegalArgumentException e) {
            LottoGameConsole.printError(LottoGameMessage.INVALID_COST_UNIT);
        }
    }

    private void readTarget() {
        try {
            target = LottoGameConsole.readTargetLotto();
        } catch (NumberFormatException e) {
            LottoGameConsole.printError(LottoGameMessage.NON_NUMBER);
        } catch (IllegalArgumentException e) {
            LottoGameConsole.printError(LottoGameMessage.INVALID_LOTTO_NUMBERS);
        }
    }

    private void readBonusNumber() {
        try {
            bonusNumber = LottoGameConsole.readBonusNumber();
        } catch (NumberFormatException e) {
            LottoGameConsole.printError(LottoGameMessage.NON_NUMBER);
        } catch (IllegalArgumentException e) {
            LottoGameConsole.printError(LottoGameMessage.NUMBER_OUT_OF_RANGE);
        }
    }
}
