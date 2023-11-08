package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoMaker lottoMaker;
    private List<Lotto> lottos;
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        readMoney();
        makeUserLotto();
        readLuckyNum();
        readBonusNum();
        announceResult();
    }

    private void readMoney() {
        while (true) {
            outputView.printRequestMoney();
            try {
                lottoMaker = new LottoMaker(inputView.receiveValue());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeUserLotto() {
        int amount = lottoMaker.calculateAmount();
        outputView.printLottoAmount(amount);
        lottos = lottoMaker.makeLotto(amount);
        printUserLotto();
    }

    private void printUserLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private void readLuckyNum() {
        while (true) {
            outputView.printRequestLuckyNum();
            try {
                LuckyNumbers luckyNumbers = new LuckyNumbers(inputView.receiveValue());
                lotto = new Lotto(luckyNumbers.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readBonusNum() {
        while (true) {
            outputView.printRequestBonusNum();
            try {
                bonusNumber = new BonusNumber(inputView.receiveValue(), lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void announceResult() {
        Compare compare = new Compare();
        compare.matchLotto(lottos, lotto, bonusNumber);
        outputView.printMatchResult(compare.getWinningRank());

        String revenueRate = compare.caculateProfits(lottoMaker.getMoney());
        outputView.printRevenueRate(revenueRate);
    }

}
