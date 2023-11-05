package lotto.controller;

import lotto.view.InputView;
import lotto.domain.*;


import java.util.ArrayList;
import java.util.List;

import static lotto.view.ExceptionMessage.*;
import static lotto.view.OutputLottoList.*;
import static lotto.view.OutputLottoResult.*;

public class LottoController {
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
                lottoAmount = new LottoAmount(InputView.setPurchaseAmount());
                ticketCount = lottoAmount.getTicketCount();
                printTicketCount(ticketCount);
                break;
            } catch (NumberFormatException e) {
                System.err.println(notNumberException());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void generateLottoNumbers(int ticketCount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lotto = lottoGenerator.randomNumber(ticketCount);
        printLottoList(lotto);

    }

    private void getInputLottoNumbers() {
        while (true) {
            try {
                Lotto winnerLotto = new Lotto(InputView.setLottoNumber());
                winnerLottoList = winnerLotto.getNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void getInputBonusNumbers() {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.setBonusBall();
                winningNumber = new WinningNumber(winnerLottoList, bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.err.println(notNumberException());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void resultLotto(LottoAmount lottoAmount, WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();

        printResultMessage();
        lottoResult.calcWinning(winningNumber, lotto);
        RateOnReturn rateOnReturn = new RateOnReturn(lottoAmount, lottoResult);
        printStatistics(lottoResult, rateOnReturn);
    }
}
