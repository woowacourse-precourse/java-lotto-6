package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.input.InputBonusNumber;
import lotto.model.input.InputMoney;
import lotto.model.input.InputWinnerNumbers;
import lotto.model.Lotto;
import lotto.model.LottoBonusPair;
import lotto.view.LottoInputView;
import lotto.view.View;

public class InputService implements Service {

    InputService() {
    }

    public Integer getInputMoney(LottoInputView lottoInputView) {
        lottoInputView.requestMoney();
        return getValidMoney().sendInputData();
    }

    public Lotto getInputWinnerNumbers(LottoInputView lottoInputView) {
        lottoInputView.requestWinnerNumbers();
        return getValidNumbers();
    }

    public LottoBonusPair getLottoBonusPair(Lotto winnerNumber, LottoInputView lottoInputView) {
        lottoInputView.requestBonusNumber();
        return getValidInputBonusNumber(winnerNumber);
    }

    private InputMoney getValidMoney() {
        InputMoney inputMoney;
        try {
            String input = Console.readLine();
            inputMoney = InputMoney.getInstance(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidMoney();
        }

        return inputMoney;
    }

    private Lotto getValidNumbers() {
        InputWinnerNumbers inputWinnerNumbers;
        Lotto winnerNumbers;
        try {
            String input = Console.readLine();
            inputWinnerNumbers = InputWinnerNumbers.getInstance(input);
            winnerNumbers = inputWinnerNumbers.sendInputData();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidNumbers();
        }

        return winnerNumbers;
    }

    private LottoBonusPair getValidInputBonusNumber(Lotto winnerNumber) {
        InputBonusNumber inputBonusNumber;
        LottoBonusPair lottoBonusPair;
        try {
            String input = Console.readLine();
            inputBonusNumber = InputBonusNumber.getInstance(input);
            lottoBonusPair = LottoBonusPair.getInstance(winnerNumber, inputBonusNumber.sendInputData());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidInputBonusNumber(winnerNumber);
        }

        Console.close();
        return lottoBonusPair;
    }
}
