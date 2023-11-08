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

    /**
     * 구입 금액을 입력 받는 메서드. 유효성을 검사하고, 유효하지 않으면 다시 입력 받는다.
     *
     * @return Integer 타입으로 변환된 유효한 입력값
     */
    public Integer getInputMoney() {
        inputView.requestMoney();
        return getValidMoney().sendInputData();
    }

    /**
     * 당첨 번호를 입력 받는 메서드. 유효성을 검사하고, 유효하지 않으면 다시 입력 받는다.
     *
     * @return Lotto 타입으로 변환된 유효한 입력값
     */
    public Lotto getInputWinnerNumbers() {
        inputView.requestWinnerNumbers();
        return getValidNumbers();
    }

    /**
     * 보너스 번호를 입력 받는 메서드. 유효성을 검사하고, 유효하지 않으면 다시 입력 받는다.
     *
     * @param winnerNumber 당첨 번호(Lotto)
     * @return 당첨 번호와 보너스 번호 묶음(LottoBonusPair)으로 변환된 유효한 입력값
     */
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