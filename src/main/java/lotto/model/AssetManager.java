package lotto.model;

import lotto.ErrorMessages;
import lotto.Lotto;

import java.util.List;

public class AssetManager {
    private static final int ZERO = 0;
    private final Integer budget;
    private int lottoNum;
    private List<Lotto> lottos;

    public AssetManager(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void countLottoNum() {
        this.lottoNum = this.budget / Rule.LOTTO_PRICE.value();
    }

    private void validateBudget(int budget) throws IllegalArgumentException {
        if (budget % Rule.LOTTO_PRICE.value() != ZERO) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_REMAINDER.value());
        }

        if (budget < Rule.LOTTO_PRICE.value()) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LOW_BUDGET.value());
        }
    }

    private void buyLottos() {
        DrawMachine drawMachine = new DrawMachine();

        countLottoNum();
        for (int i = 0; i < this.lottoNum; i++) {
            this.lottos.add(new Lotto(drawMachine.pickLottoNumbers()));
        }
    }
}
