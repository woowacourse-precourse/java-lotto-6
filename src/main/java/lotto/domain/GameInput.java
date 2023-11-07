package lotto.domain;

import java.util.List;

public class GameInput {

    private final int purchaseAmount;
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    public GameInput(InputReader inputReader) {
        this.purchaseAmount = inputReader.readAndValidatePurchaseAmount();
    }

    public void setLottoNumbersAndBonusNumber(InputReader inputReader) {
        this.lottoNumbers = inputReader.readAndValidateNumbers();
        this.bonusNumber = inputReader.readAndValidateBonumNumber();
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
