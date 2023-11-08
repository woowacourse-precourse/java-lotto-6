package lotto.controller;

import lotto.service.AutoLottoNumber;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.WinningNumber;
import lotto.service.TotalReturn;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Person {
    private final InputView inputView;
    private final OutputView outputView;

    public Person(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyLotto() {

        LottoAmount lottoAmount = inputCashInHand();
        Lotto[] autoLotto = new Lotto[lottoAmount.getLottoAmount()];
        autoLotto(autoLotto, lottoAmount);

        WinningNumber winningNumber = inputWinningNumber();
        BonusNumber bonusNumber = inputBonus(winningNumber);

        int[] ranking = new int[8];

        for (int index = 0; index < lottoAmount.getLottoAmount(); index++) {
            ranking[winningNumber.checkLotto(autoLotto[index].getLotto(), bonusNumber)]++;
        }
        outputView.printResult(ranking, TotalReturn.getTotalReturnRate(ranking, lottoAmount.getLottoAmount()));

    }

    private LottoAmount inputCashInHand() {
        while (true) {
            try {
                return new LottoAmount(inputView.readCash());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void autoLotto(Lotto[] autoLotto, LottoAmount Amount) {
        outputView.printAmount(Amount.getLottoAmount());
        for (int index = 0; index < Amount.getLottoAmount(); index++) {
            autoLotto[index] = new Lotto(AutoLottoNumber.putOutNumber());
            outputView.printLotto(autoLotto[index].getLotto());
        }
    }

    private WinningNumber inputWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(inputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonus(WinningNumber winningNumber) {
        while (true) {
            try {
                return new BonusNumber(inputView.readBonusNumber(),
                        winningNumber.getWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
