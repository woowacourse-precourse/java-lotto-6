package lotto;

import view.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    //    private static List<Integer> lotto = new ArrayList<>();
    private static Lotto lotto;

    static List<Integer> winNums;

    public void start() {
        boolean result = true;
        int bonusNum;
        int amount = Input.inputLottoAmount();

        InputWinNum();

        List<Integer> passedWinNums = lotto.getNumbers();

        while (result) {
            bonusNum = Input.inputBonusNum();
            result = lotto.validateBonusNum(bonusNum, passedWinNums);
        }

    }

    private static List<Integer> InputWinNum() {
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


}
