package lotto.controller;

import lotto.domain.*;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private LottoByPlayer lottoByPlayer;
    private LottoAmount lottoAmount;
    private final LottoGenerator lottoGenerator;
    private LottoResult lottoResult;
    private Validator validator;


    private List<Integer> numberFromGenerator;
    private List<List<Integer>> quantityOfLotto;
    private int purchaseQuantity;
    private int purchaseAmount;
    private List<Integer> numberFromPlayer;
    private int bonusNumber;

    public LottoGame() {
        lottoGenerator = new LottoGenerator();
        validator = new Validator();
        lottoAmount = new LottoAmount();
        numberFromPlayer = new ArrayList<>();
        numberFromGenerator = new ArrayList<>();
        quantityOfLotto = new ArrayList<>();

    }

    public void start() {
        this.purchaseAmount = setPurchaseAmount();
        printPurchaseQuantity();
        printListOfLotto();
        this.numberFromPlayer = setLottoNumber();
        this.bonusNumber = setBonusNumber();

        lottoResult = new LottoResult(numberFromPlayer, bonusNumber, quantityOfLotto);
        printWinningResult();
        printTotalRateOfReturn();
    }

    private int setPurchaseAmount() {
        try {
            return lottoAmount.validatePurchaseAmount(InputView.getPurchaseAmountInputFromPlayer());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPurchaseAmount();
        }
    }

    private void printPurchaseQuantity() {
        this.purchaseQuantity = lottoAmount.getPurchaseQuantityOfLotto(purchaseAmount);
        OutputView.printMessageOfPurchaseQuantity(purchaseQuantity);
    }

    private List<List<Integer>> makeListOfLotto() {
        for (int i = 0; i < purchaseQuantity; i++) {
            numberFromGenerator = lottoGenerator.generateLottoNumbers();
            quantityOfLotto.add(numberFromGenerator);
        }
        return this.quantityOfLotto;
    }

    private void printListOfLotto() {
        makeListOfLotto();
        for (List<Integer> lotto : quantityOfLotto) {
            OutputView.printLottoNumbers(lotto);
        }
    }

    private List<Integer> setLottoNumber() {
        try {
            List<Integer> number = validator.validateInput(InputView.getWinningNumberInputFromPlayer());
            lottoByPlayer = new LottoByPlayer(number);
            return lottoByPlayer.getLottoNumberFromPlayer();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLottoNumber();
        }
    }

    private int setBonusNumber() {
        try {
            return lottoByPlayer.validateBonusNumber(InputView.getBonusNumberInputFromPlayer(), numberFromPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }


    private void printWinningResult() {
        OutputView.printWinningStatistics(lottoResult.compare());
    }

    private void printTotalRateOfReturn() {
        OutputView.printTotalRateOfReturn(lottoResult.getRateOfReturn(purchaseAmount));
    }
}
