package lotto.controller;

import lotto.domain.InputValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

import java.util.List;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoGame {
    private final LottoNumbers lottoNumbers;
    private Lotto lotto;
    private InputValidator inputValidator;
    private int purchaseAmount;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        lotto = new Lotto(lottoNumbers.numbers);
        inputValidator = new InputValidator();
    }

    public void start() {
        this.purchaseAmount = setPurchaseAmount();
        //8개를 구입했습니다. 로또 번호 출력
        this.winningNumber = setWinningNumber();
        this.bonusNumber = setBonusNumber();
    }

    public int setPurchaseAmount() {
        try {
            return inputValidator.validatePurchaseAmount(InputView.getPurchaseAmountInputFromPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPurchaseAmount();
        }
    }

    public List<Integer> setWinningNumber() {
        try {
            return inputValidator.validateWinningNumbers(InputView.getWinningNumberInputFromPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumber();
        }
    }

    public int setBonusNumber() {
        try {
            return inputValidator.validateBonusNumber(InputView.getBonusNumberInputFromPlayer(), winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }

    public int getPurchaseQuantityOfLotto(int purchaseAmount) {
        return purchaseAmount / PRICE_OF_ONE_LOTTO;
    }
}
