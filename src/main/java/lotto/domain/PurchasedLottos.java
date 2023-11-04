package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.Messages;
import lotto.constants.Values;
import lotto.utils.RandomNumberGenerator;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    public PurchasedLottos(int purchaseAmount) {
        validate(purchaseAmount);
        this.lottos = createPurchasedLottos(purchaseAmount);
    }

    private List<Lotto> createPurchasedLottos(int purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        int numberOfLottosToPurchase = purchaseAmount / Values.LOTTO_PURCHASE_UNIT;
        for (int i = 0; i < numberOfLottosToPurchase; i++) {
            Lotto lotto = new Lotto(RandomNumberGenerator.generateRandomNumbers());
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }

    public void validate(int purchaseAmount) {
        if (isAmountLessThanUnit(purchaseAmount)) {
            throw new IllegalArgumentException(Messages.ERROR_AMOUNT_LESS_THAN_UNIT);
        }
        if (isNotMultipleOfLottoPurchaseUnit(purchaseAmount)) {
            throw new IllegalArgumentException(Messages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
    }

    private boolean isAmountLessThanUnit(int purchaseAmount) {
        return purchaseAmount < Values.LOTTO_PURCHASE_UNIT;
    }

    private boolean isNotMultipleOfLottoPurchaseUnit(int purchaseAmount) {
        return Values.LOTTO_PURCHASE_UNIT != 0 && purchaseAmount % Values.LOTTO_PURCHASE_UNIT != 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        String purchaseMessage = String.format(Messages.PURCHASE_MESSAGE, lottos.size());
        String lottosString = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        return purchaseMessage + "\n" + lottosString;
    }
}
