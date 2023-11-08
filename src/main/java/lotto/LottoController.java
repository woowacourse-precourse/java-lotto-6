package lotto;

import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static Lotto lotto;

    private static LottoAmount lottoAmount;

    static List<Integer> winNums;

    public void start() {
        boolean result = true;
        int bonusNum;

        int amount = getInputAmount();

        int count = lottoAmount.calculateLottoCount();
        Output.printLottoCount(count);

        winNums = getInputWinNum();

        List<Integer> passedWinNums = lotto.getNumbers();

        while (result) {
            bonusNum = Input.inputBonusNum();
            result = lotto.validateBonusNum(bonusNum, passedWinNums);
        }

    }

    private static List<Integer> getInputWinNum() {
        while (true) {
            try {
                winNums = Input.inputWinNums();
                lotto = new Lotto(winNums);
                return winNums;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getInputAmount() {
        while (true) {
            try {
                int amount = Input.inputLottoAmount();
                lottoAmount = new LottoAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }

}
