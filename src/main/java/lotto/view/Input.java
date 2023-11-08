package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.ErrorMessage;
import lotto.Lotto;
import lotto.LottoMachine;

public class Input {
    private static final String splitter = ",";

    public Integer readPaymentAmount() {
        String input = this.read(InputMessage.PAYMENT_AMOUNT);
        this.validatePaymentAmount(input);
        return Integer.parseInt(input);
    }

    private void validatePaymentAmount(String input) {
        try {
            Integer paymentAmount = formatToNumber(input);
            new LottoMachine(paymentAmount);
        } catch (IllegalArgumentException exception) {
            this.readPaymentAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        String input = this.read(InputMessage.WINNING_NUMBERS);
        this.validateWinningNumbers(input);
        return new Lotto(formatInputToLottoNumbers(input)).getNumbers();
    }

    private void validateWinningNumbers(String input) {
        try {
            List<Integer> winningNumbers = formatInputToLottoNumbers(input);
            new Lotto(winningNumbers);
        } catch (IllegalArgumentException exception) {
            this.readWinningNumbers();
        }
    }

    private static List<Integer> formatInputToLottoNumbers(String input) {
        return Arrays.stream((input.split(splitter))).map(Input::formatToNumber).toList();
    }

    public Integer readBonusNumber() {
        String input = this.read(InputMessage.BONUS_NUMBER);
        this.validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private void validateBonusNumber(String input) {
        try {
            Integer number = formatToNumber(input);
            Lotto.validateNumberRange(number);
        } catch (IllegalArgumentException exception) {
            this.readBonusNumber();
        }
    }

    private String read(InputMessage inputMessage) {
        System.out.println(inputMessage);
        return Console.readLine();
    }

    private static Integer formatToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }
}
