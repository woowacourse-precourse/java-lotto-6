package lotto;

import lotto.InputView;
import lotto.LottoAmount;
import lotto.AutoLottoNumber;
import lotto.Lotto;

public class Person {
    private final InputView inputView;

    public Person(InputView inputView) {
        this.inputView = inputView;
    }

    public void buyLotto() {
        LottoAmount lottoAmount = InputCashInHand();

        Lotto[] autoLotto = new Lotto[lottoAmount.getLottoAmount()];
        AutoLotto(autoLotto, lottoAmount);

        WinningNumber winningNumber = InputWinningNumber();

        BonusNumber bonusNumber = InputBonus(winningNumber);

        int[] ranking = new int[8];

        for(int index = 0; index < lottoAmount.getLottoAmount();index++){
            ranking[winningNumber.checkLotto(autoLotto[index].getLotto(), bonusNumber)]++;
        }

    }

    private LottoAmount InputCashInHand() {
        while (true) {
            try {
                return new LottoAmount(inputView.readCash());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void AutoLotto(Lotto[] autoLotto, LottoAmount Amount) {
        for (int index = 0; index < Amount.getLottoAmount(); index++) {
            autoLotto[index] = new Lotto(AutoLottoNumber.putOutNumber());
        }
    }

    private WinningNumber InputWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(inputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber InputBonus(WinningNumber winningNumber) {
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
