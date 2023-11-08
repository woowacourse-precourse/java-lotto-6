package lotto.domain;

import lotto.validation.PlayerValidation;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Player(int purchaseAmount) {
        this.lottos = new ArrayList<>();
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        PlayerValidation.validatePurchaseAmount(purchaseAmount);
    }
}
