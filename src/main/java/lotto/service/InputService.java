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
    private final LottoInputView inputView;

    InputService(final View lottoInputView) {
        inputView = (LottoInputView) lottoInputView;
    }

    public Integer getInputMoney() {
        inputView.requestMoney();
        return getValidMoney().sendInputData();
    }

    public Lotto getInputWinnerNumbers() {
        inputView.requestWinnerNumbers();
        return getValidNumbers();
    }

    public LottoBonusPair getLottoBonusPair(final Lotto winnerNumber) {
        inputView.requestBonusNumber();
        return getValidInputBonusNumber(winnerNumber);
    }

    private InputMoney getValidMoney() {
        InputMoney inputMoney;
        try {
            String input = Console.readLine();
            inputMoney = InputMoney.getInstance(input);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
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
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getValidNumbers();
        }
        return winnerNumbers;
    }

    private LottoBonusPair getValidInputBonusNumber(final Lotto winnerNumber) {
        InputBonusNumber inputBonusNumber;
        LottoBonusPair lottoBonusPair;
        try {
            String input = Console.readLine();
            inputBonusNumber = InputBonusNumber.getInstance(input);
            lottoBonusPair = LottoBonusPair.getInstance(winnerNumber, inputBonusNumber.sendInputData());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getValidInputBonusNumber(winnerNumber);
        }
        Console.close();
        return lottoBonusPair;
    }
}
