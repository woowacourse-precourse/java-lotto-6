package lotto.domain;

import java.util.List;

public class GameInput {

    private final int purchaseAmount;
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    public GameInput(InputReader inputReader) {
        this.purchaseAmount = inputReader.readAndValidatePurchaseAmount();
        this.lottoNumbers = inputReader.readAndValidateNumbers();
        this.bonusNumber = inputReader.readAndValidateBonumNumber();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int calculateLottoPurchase() {
        return purchaseAmount / 1000;
    }
}
