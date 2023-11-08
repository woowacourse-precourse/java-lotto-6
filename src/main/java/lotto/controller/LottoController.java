package lotto.controller;

import lotto.model.WinningNumbers;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    public void start() {

        //당첨 번호, 보너스 번호 입력 단계
        List<Integer> numbersInput = InputView.inputWinningNumbers();
        int numberInput = InputView.inputBonusNumber(numbersInput);
        WinningNumbers.getInstance(numbersInput, numberInput);
    }
}
