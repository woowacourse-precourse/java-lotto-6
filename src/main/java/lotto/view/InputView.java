package lotto.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validation.AmountValidator;
import lotto.util.validation.LottoNumberValidator;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public int readAmount() {
        while (true) {
            System.out.println(AMOUNT_MESSAGE);
            try {
                final String inputAmount = Console.readLine();
                validateAmount(inputAmount);
                return Integer.parseInt(inputAmount);
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateAmount(final String inputAmount) {
        final AmountValidator validator = AmountValidator.getInstance();
        validator.validate(inputAmount);
    }

    public int readBonusNumber() {
        while (true) {
            System.out.println(BONUS_NUMBER_MESSAGE);
            try {
                final String inputBonusNumber = Console.readLine();
                validateLottoNumber(inputBonusNumber);
                return Integer.parseInt(inputBonusNumber);
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        while (true) {
            System.out.println(WINNING_NUMBER_MESSAGE);
            try {
                final String inputWinningNumber = Console.readLine();
                final String[] inputWinningNumbers = inputWinningNumber.split(DELIMITER);
                validateLottoNumbers(inputWinningNumbers);
                return convertToIntegerList(inputWinningNumbers);
            } catch (final IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateLottoNumbers(final String[] lottoNumbers) {
        for (final String lottoNumber : lottoNumbers) {
            validateLottoNumber(lottoNumber);
        }
    }

    private void validateLottoNumber(final String lottoNumber) {
        final LottoNumberValidator validator = LottoNumberValidator.getInstance();
        validator.validate(lottoNumber);
    }

    private List<Integer> convertToIntegerList(final String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    private static class InputViewHolder {
        private static final InputView INSTANCE = new InputView();
    }
}
