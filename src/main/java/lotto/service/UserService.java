package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottosDto;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.RandomNumberGenerator;

public class UserService {
    private PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();

    public void validatePurchaseAmount(String purchaseAmountInput) {
        purchaseAmount = PurchaseAmount.create(purchaseAmountInput);
    }

    public LottosDto purchaseLottos() {
        for (int i = 0; i < calculateNumberOfPurchase(); i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateUniqueSixNumber();
            lottos.add(new Lotto(randomNumbers));
        }
        return getLottosDto();
    }

    private Integer calculateNumberOfPurchase() {
        return purchaseAmount.getPurchaseAmount() / Lotto.PRICE;
    }

    public LottosDto getLottosDto() {
        return LottosDto.create(lottos);
    }
}
