package lotto.controller;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class LottoController {
    private InputMoney inputDeviceForMoney;
    private InputWinningNumber inputDeviceForWinningNumber;
    private InputBonusNumber inputDeviceForBonusNumber;
    private OutputLottos lottoPrinter;
    private Calculate calc;
    private RatingAndPrinting printer;

    private WinningNumber winningNumber;
    private int bonusNumber;
    private List<Lotto> lottos;
    private Money money;

    public void start() {
        depositMoney();
        createLotteryTicket();
        checkMyLotteryTicket();
        makeWinningTicket();
        calculateMyRate();
        checkResult();
    }

    private void depositMoney() {
        inputDeviceForMoney = new InputMoney();
        money = inputDeviceForMoney.enterAmountOfMoney();
    }

    private void createLotteryTicket() {
        LottoPublishing publisher = new LottoPublishing();
        lottos = publisher.publishLotto(money.getTicketQuantity());
    }

    private void checkMyLotteryTicket() {
        lottoPrinter = new OutputLottos(lottos);
    }

    private void makeWinningTicket() {
        inputDeviceForWinningNumber = new InputWinningNumber();

        winningNumber = inputDeviceForWinningNumber.enterWinningNumber();
        inputDeviceForBonusNumber = new InputBonusNumber(winningNumber);
        bonusNumber = inputDeviceForBonusNumber.enterBonusNumber(bonusNumber);
    }

    private void calculateMyRate() {
        List<Integer> answer = winningNumber.getWinningLotto();
        calc = new Calculate(lottos, answer, bonusNumber);
        calc.countAll();
    }

    private void checkResult() {
        printer = new RatingAndPrinting(lottos);
        printer.printResult(calc.getRank(), money.getMoney());
    }
}