package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.ExceptionMessage;
import lotto.view.InputView;
import lotto.domain.*;
import lotto.view.OutputView;


import java.util.ArrayList;
import java.util.List;


public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ExceptionMessage exceptionMessage = new ExceptionMessage();
    private static LottoAmount lottoAmount;
    private static int ticketCount;
    private static List<Lotto> lotto = new ArrayList<>();
    private static WinningNumber winningNumber;
    private static List<Integer> winnerLottoList = new ArrayList<>();


    public void Start() {
        getLottoAmount();

        generateLottoNumbers(ticketCount);

        getInputLottoNumbers();
        getInputBonusNumbers();

        resultLotto(lottoAmount, winningNumber);
    }


    private void getLottoAmount() {
        while (true) {
            try {
                lottoAmount = new LottoAmount(inputView.setPurchaseAmount());
                ticketCount = lottoAmount.getTicketCount();
                outputView.printTicketCount(ticketCount);
                break;
            } catch (NumberFormatException e) {
                System.out.println(exceptionMessage.notNumberException());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateLottoNumbers(int ticketCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lotto = lottoGenerator.randomNumber(ticketCount);
        outputView.printLottoList(lotto);

    }

    private void getInputLottoNumbers() {
        while (true) {
            try {
                Lotto winnerLotto = new Lotto(inputView.setLottoNumber());
                winnerLottoList = winnerLotto.getNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getInputBonusNumbers() {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = inputView.setBonusBall();
                winningNumber = new WinningNumber(winnerLottoList, bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(exceptionMessage.notNumberException());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void resultLotto(LottoAmount lottoAmount, WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();

        outputView.printResultMessage();
        lottoResult.calcWinning(winningNumber, lotto);
        RateOnReturn rateOnReturn = new RateOnReturn(lottoAmount, lottoResult);
        outputView.printStatistics(lottoResult, rateOnReturn);
    }
}
