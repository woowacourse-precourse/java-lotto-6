package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.IllegalStateExceptionType;
import lotto.domain.LottoGenerateStrategy;

public final class LottoDispenser {
    private final LottoGenerateStrategy lottoGenerateStrategy;
    private final LottoPurchaseCost lottoPurchaseCost;
    private boolean isDispensed;

    public LottoDispenser(LottoGenerateStrategy lottoGenerateStrategy, LottoPurchaseCost lottoPurchaseCost) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
        this.lottoPurchaseCost = lottoPurchaseCost;
        isDispensed = false;
    }

    private void validateIsDispensed() {
        if (isDispensed) {
            throw IllegalStateExceptionType.LOTTO_ALREADY_DISPENSED.getException();
        }
    }

    private Lotto generateLotto() {
        return lottoGenerateStrategy.generate();
    }

    private List<Lotto> generateLottos(int lottoAmount) {
        List<Lotto> elements = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            elements.add(generateLotto());
        }

        return elements;
    }

    public List<Lotto> dispense() {
        validateIsDispensed();
        isDispensed = true;

        int lottoAmount = lottoPurchaseCost.getLottoAmount();
        return generateLottos(lottoAmount);
    }
}
