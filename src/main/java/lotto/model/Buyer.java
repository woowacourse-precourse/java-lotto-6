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

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void validateBudget(int budget) throws IllegalArgumentException {
        if (budget % Rule.LOTTO_PRICE.value() != ZERO) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_REMAINDER.value());
        }

        if (budget < Rule.LOTTO_PRICE.value()) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LOW_BUDGET.value());
        }
    }

    public void countLottoNum() {
        this.lottoCount = this.budget / Rule.LOTTO_PRICE.value();
    }
}
