package lotto.model;

import lotto.ErrorMessages;

import java.util.List;

public class Buyer {
    private static final int ZERO = 0;
    private final Integer budget;
    private int lottoCount;
    private List<Lotto> lottos;

    public Buyer(int budget) {
        validateBudget(budget);
        this.budget = budget;
    }

    private void countLottoNum() {
        this.lottoCount = this.budget / Rule.LOTTO_PRICE.value();
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
        for (int i = 0; i < this.lottoCount; i++) {
            this.lottos.add(new Lotto(drawMachine.pickLottoNumbers()));
        }
    }
}
