package lotto.controller;

import lotto.domain.*;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoGame {
    private final LottoNumbers lottoNumbers;
    private Lotto lotto;
    private Validator validator;
    private LottoWinningResult lottoWinningResult;
    private LottoAmount lottoAmount;
    private List<Integer> lottoNumber;
    private int purchaseQuantity;
    private int purchaseAmount;
    private List<Integer> numberFromPlayer;
    private int bonusNumber;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        validator = new Validator();
        lottoAmount = new LottoAmount();

    }

    public void start() {
        this.purchaseAmount = setPurchaseAmount();
        this.purchaseQuantity = lottoAmount.getPurchaseQuantityOfLotto(purchaseAmount);
        OutputView.printPurchaseQuantityMessage(purchaseQuantity);
        makeLottoList();
        this.numberFromPlayer = setWinningNumber();
        lotto = new Lotto(numberFromPlayer);
        this.bonusNumber = setBonusNumber();
        printWinningResult();
    }

    public int setPurchaseAmount() {
        try {
            return lottoAmount.validatePurchaseAmount(InputView.getPurchaseAmountInputFromPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPurchaseAmount();
        }
    }
    public void makeLottoList(){
        for (int i = 0; i < purchaseQuantity; i++) {
            OutputView.printLottoNumbers(lottoNumbers.generateLottoNumbers());
        }
    }

    public List<Integer> setWinningNumber() {
        try {
            return validator.validateInput(InputView.getWinningNumberInputFromPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumber();
        }
    }

    public int setBonusNumber() {
        try {
            return lotto.validateBonusNumber(InputView.getBonusNumberInputFromPlayer(),numberFromPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }

    public void printWinningResult() {
        lottoWinningResult = new LottoWinningResult(numberFromPlayer, bonusNumber, lottoNumbers.getLottoNumbers());
        OutputView.printWinningStatistics(lottoWinningResult.getWinningResult());
    }
}
