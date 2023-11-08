package lotto.domain;

import lotto.validation.PlayerValidation;

import java.util.ArrayList;
import java.util.Collections;
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

    public void buyLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public LottoResult calculateResult(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
