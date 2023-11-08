package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningCountDto;
import lotto.dto.WinningNumberDto;
import lotto.utility.Validation;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private int lottoCount;

    private LottoGenerator lottoGenerator;
    private Judgement judgement;

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
        judgement = new Judgement();
    }

    public void startLottoService() {
        String purchaseAmount;
        List<Lotto> userLottoCollection;
        List<LottoResultDto> lottosResult;

        WinningNumberDto winningNumberDto;
        Result result;

        purchaseAmount = purchaseLotto(); //로또 구매하기
        userLottoCollection = generateLotto(); //로또 생성하기
        winningNumberDto = setWinningAndBounsNumber(); //당첨 숫자 입력하기
        lottosResult = judgeLottoWinning(userLottoCollection, winningNumberDto); //로또와 당첨번호 비교하기
        result = setLottosResult(lottosResult); //로또 최종결과 구하기
        getProfitRate(result,purchaseAmount); //로또 수익률 계산 및 출력
    }

    private String purchaseLotto() {
        String purchaseAmount;

        purchaseAmount = inputPurchaseAmount();
        LottoChanger lottoChanger = new LottoChanger(Integer.parseInt(purchaseAmount));
        lottoCount = lottoChanger.getLottoCount();
        OutputView.printLottoCount(lottoCount);

        return purchaseAmount;
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

    private List<Lotto> generateLotto() {
        List<Lotto> userLottoCollection;

        userLottoCollection = lottoGenerator.generate(lottoCount);
        for (Lotto lotto : userLottoCollection) {
            OutputView.printLottoNumbers(lotto.getLottoNumbers());
        }

        return userLottoCollection;
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

    private List<LottoResultDto> judgeLottoWinning(List<Lotto> userLottoCollection, WinningNumberDto winningNumberDto) {
        List<LottoResultDto> lottosResult = new ArrayList<>();

        for (int i = 0; i < userLottoCollection.size(); i++) {
            lottosResult.add(judgement.countLottoCorrectNumbers(userLottoCollection.get(i), winningNumberDto));
        }
        Collections.unmodifiableList(lottosResult); //불변리스트로 변경

        return lottosResult;
    }

    private Result setLottosResult(List<LottoResultDto> lottosResult){
        Result result = new Result(lottosResult);
        OutputView.printLottosResult(result.getWinningCountDto());

        return result;
    }

    private void getProfitRate(Result result, String purchaseAmount){
        BigDecimal profitRate = result.calculateProfitRate(Integer.parseInt(purchaseAmount));
        OutputView.printLottoProfitRate(profitRate);
    }
}
