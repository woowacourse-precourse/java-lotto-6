package lotto;

import view.Input;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    //    private static List<Integer> lotto = new ArrayList<>();
    private Lotto lotto;

    public void start() {
        List<Integer> winNums;

        boolean result = true;
        int bonusNum;
        int amount = Input.inputLottoAmount();

        while (true) {
            winNums = Input.inputWinNums();
            lotto = new Lotto(winNums);
            break;
        }

        List<Integer> passedWinNums = lotto.getNumbers();

        while (result) {
            bonusNum = Input.inputBonusNum();
            result = lotto.validateBonusNum(bonusNum, passedWinNums);
        }

    }


}
