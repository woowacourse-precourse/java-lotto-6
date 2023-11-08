package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoChanger;
import lotto.domain.LottoGenerator;
import lotto.utility.Validation;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoManager {
    private int lottoCount;
    private List<Lotto> lottoCollection;


    private LottoGenerator lottoGenerator;

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
    }

    public void startLottoService() {
        purchaseLotto(); //로또 구매하기
        generateLotto(); //로또 생성하기
        setWinningAndBounsNumber(); //당첨 숫자 입력하기
    }

    private void purchaseLotto() {
        String purchaseAmount;

        purchaseAmount = inputPurchaseAmount();
        LottoChanger lottoChanger = new LottoChanger(Integer.parseInt(purchaseAmount));
        lottoCount = lottoChanger.getLottoCount();
        OutputView.printLottoCount(lottoCount);
    }

    private String inputPurchaseAmount() {
        String purchaseAmount;

        try {
            purchaseAmount = InputView.readUserLottoPurchaseAmount();
            Validation.vaildatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException | IllegalStateException e) {
            ExceptionView.printExceptionMessage(e.getMessage());
            purchaseAmount = inputPurchaseAmount();
        }

        return purchaseAmount;
    }

    private void generateLotto() {
        lottoCollection = lottoGenerator.generate(lottoCount);
        for (Lotto lotto : lottoCollection) {
            OutputView.printLottoNumbers(lotto.getLottoNumbers());
        }
    }

    private void setWinningAndBounsNumber() {
        String winningNumber;

        winningNumber = setWinningNumber();
    }

    private String setWinningNumber() {
        String winningNumber;

        try {
            winningNumber = InputView.readWinningNumber();
            Validation.vaildateWinningNumbers(winningNumber);
        } catch (IllegalArgumentException | IllegalStateException e) {
            ExceptionView.printExceptionMessage(e.getMessage());
            winningNumber = setWinningNumber();
        }

        return winningNumber;
    }
}
