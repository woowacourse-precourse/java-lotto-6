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
    private final LottoInputView lottoInputView;

    InputService(View lottoInputView) {
        this.lottoInputView = (LottoInputView) lottoInputView;
    }

//    public static InputService getInstance(View lottoInputView) {
//        return new InputService(lottoInputView);
//    }

    public Integer getInputMoney() {
        lottoInputView.requestMoney();
        return getValidMoney().sendInputData();
    }

    public Lotto getInputWinnerNumbers() {
        lottoInputView.requestWinnerNumbers();
        return getValidNumbers().sendInputData();
    }

    public LottoBonusPair getLottoBonusPair(Lotto winnerNumber) {
        lottoInputView.requestBonusNumber();
        return getValidInputBonusNumber(winnerNumber);
    }

    private InputMoney getValidMoney() {
        InputMoney inputMoney;
        try {
            String input = Console.readLine();
            inputMoney = InputMoney.getInstance(input);
        } catch (IllegalArgumentException e) {
            return getValidMoney();
        }

        return inputMoney;
    }

    private InputWinnerNumbers getValidNumbers() {
        InputWinnerNumbers inputWinnerNumbers;
        try {
            String input = Console.readLine();
            inputWinnerNumbers = InputWinnerNumbers.getInstance(input);
        } catch (IllegalArgumentException e) {
            return getValidNumbers();
        }

        return inputWinnerNumbers;
    }

    private LottoBonusPair getValidInputBonusNumber(Lotto winnerNumber) {
        InputBonusNumber inputBonusNumber;
        LottoBonusPair lottoBonusPair;
        try {
            String input = Console.readLine();
            inputBonusNumber = InputBonusNumber.getInstance(input);
            lottoBonusPair = LottoBonusPair.getInstance(winnerNumber, inputBonusNumber.sendInputData());
        } catch (IllegalArgumentException e) {
            return getValidInputBonusNumber(winnerNumber);
        }

        Console.close();
        return lottoBonusPair;
    }
}
