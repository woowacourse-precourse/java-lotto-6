package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoChanger;
import lotto.domain.LottoGenerator;
import lotto.dto.WinningNumberDto;
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
        WinningNumberDto winningNumberDto;

        purchaseLotto(); //로또 구매하기
        generateLotto(); //로또 생성하기
        winningNumberDto = setWinningAndBounsNumber(); //당첨 숫자 입력하기
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

    private WinningNumberDto setWinningAndBounsNumber() {
        String winningNumber;
        String bonusNumber;

        winningNumber = setWinningNumber();
        bonusNumber = setBonusNumber();

        return new WinningNumberDto(winningNumber, bonusNumber);
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

    private String setBonusNumber() {
        String bonusNumber;

        try {
            bonusNumber = InputView.readBonusNumber();
            Validation.validateBonusNumber(bonusNumber);
        } catch (IllegalArgumentException | IllegalStateException e) {
            ExceptionView.printExceptionMessage(e.getMessage());
            bonusNumber = setBonusNumber();
        }

        return bonusNumber;
    }
}
