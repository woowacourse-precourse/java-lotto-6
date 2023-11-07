package lotto.controller;

import lotto.domain.*;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoGame {

    private Lotto lotto;
    private LottoAmount lottoAmount;
    private final LottoNumbers lottoNumbers;
    private LottoWinningResult lottoWinningResult;
    private Validator validator;


    private List<Integer> lottoNumber;
    private List<List<Integer>> quantityOfLotto;
    private int purchaseQuantity;
    private int purchaseAmount;
    private List<Integer> numberFromPlayer;
    private int bonusNumber;
    private Map<Rank, Integer> prizeCount;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        validator = new Validator();
        lottoAmount = new LottoAmount();

    }

    public void start() {
        this.purchaseAmount = setPurchaseAmount();
        this.purchaseQuantity = lottoAmount.getPurchaseQuantityOfLotto(purchaseAmount);
        OutputView.printPurchaseQuantityMessage(purchaseQuantity);
        makeListOfLotto();
        this.numberFromPlayer = setWinningNumber();
        lotto = new Lotto(numberFromPlayer); //사용자가 입력한 당첨번호 검증
        this.bonusNumber = setBonusNumber();
        lottoWinningResult = new LottoWinningResult(numberFromPlayer, bonusNumber, quantityOfLotto);
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

    public List<List<Integer>> makeListOfLotto() {
        quantityOfLotto = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoNumber = lottoNumbers.generateLottoNumbers();
            Collections.sort(lottoNumber);
            quantityOfLotto.add(lottoNumber);
            OutputView.printLottoNumbers(lottoNumber);
        }
        return quantityOfLotto;
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
            return lotto.validateBonusNumber(InputView.getBonusNumberInputFromPlayer(), numberFromPlayer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBonusNumber();
        }
    }


    public void printWinningResult() {
        lottoWinningResult.compare(numberFromPlayer, quantityOfLotto);
        prizeCount = lottoWinningResult.getPrizeCount();
        OutputView.printWinningStatistics(prizeCount);
    }
}
