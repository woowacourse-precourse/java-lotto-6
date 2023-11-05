package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.Messages;
import lotto.constants.Values;
import lotto.utils.generator.LottsGenerator;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    public PurchasedLottos(int purchaseAmount, LottsGenerator lottsGenerator) {
        validate(purchaseAmount);
        this.lottos = lottsGenerator.generateLottos(purchaseAmount);
    }

    public void validate(int purchaseAmount) {
        if (isAmountLessThanUnit(purchaseAmount)) {
            throw new IllegalArgumentException(Messages.ERROR_AMOUNT_LESS_THAN_UNIT);
        }
        if (isAmountMoreThanUnit(purchaseAmount)) {
            throw new IllegalArgumentException(Messages.ERROR_AMOUNT_MAX_RANGE);
        }
        if (isNotMultipleOfLottoPurchaseUnit(purchaseAmount)) {
            throw new IllegalArgumentException(Messages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
    }

    private boolean isAmountLessThanUnit(int purchaseAmount) {
        return purchaseAmount < Values.LOTTO_PURCHASE_UNIT;
    }

    private boolean isAmountMoreThanUnit(int purchaseAmount) {
        return purchaseAmount > Values.LOTTO_MAX_PURCHASE_AMOUNT;
    }

    private boolean isNotMultipleOfLottoPurchaseUnit(int purchaseAmount) {
        return Values.LOTTO_PURCHASE_UNIT != 0 && purchaseAmount % Values.LOTTO_PURCHASE_UNIT != 0;
    }

    @Override
    public String toString() {
        String purchaseMessage = String.format(Messages.PURCHASE_MESSAGE, lottos.size());
        String lottosString = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining());

        return purchaseMessage + lottosString;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
