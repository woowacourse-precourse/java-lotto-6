package lotto.controller;

import lotto.domain.*;
import lotto.io.Input;
import lotto.io.Output;

public class LottoController {
    private final Input input;

    public LottoController() {
        this.input = new Input();
    }

    public void run() {
        Money money = getMoneyFromUser();

        LottoStore lottoStore = purchaseLotto(money);

        LottoAnswer lottoAnswer = getLottoAnswerFromUser();


        while (true) {
            try {
                BonusNumber bonusNumber = getBonusNumberFromUser();
                lottoAnswer.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        displayStatics(lottoStore, lottoAnswer, money);
    }

    private void displayStatics(LottoStore lottoStore, LottoAnswer lottoAnswer, Money money) {
        WinningStatistics winningStatistics = new WinningStatistics(lottoStore, lottoAnswer, money);
        Output.displayStatisticsHeader();
        Output.displayMatchingResult(winningStatistics);
        Output.displayReturnRatio(winningStatistics);
    }

    private BonusNumber getBonusNumberFromUser() {
        BonusNumber bonusNumber;
        while (true) {
            try {
                Output.displayBonusNumberPrompt();
                bonusNumber = input.setBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return bonusNumber;
    }

    private LottoAnswer getLottoAnswerFromUser() {
        LottoAnswer lottoAnswer;
        while (true) {
            try {
                Output.displayLottoAnswerPrompt();
                lottoAnswer = input.setLottoAnswer();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return lottoAnswer;
    }

    private LottoStore purchaseLotto(Money money) {
        LottoStore lottoStore = new LottoStore(money);
        Output.displayLottoStoreNumbers(lottoStore);
        System.out.println();
        return lottoStore;
    }

    private Money getMoneyFromUser() {
        Money money;
        while (true) {
            try {
                Output.displayPurchaseAmountPrompt();
                money = input.setMoney();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return money;
    }
}