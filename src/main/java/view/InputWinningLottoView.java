package view;

import camp.nextstep.edu.missionutils.Console;
import exception.EmptyException;
import exception.NonNumericException;
import java.util.ArrayList;
import java.util.List;

public class InputWinningLottoView {
    private static final String INTEGER_REGEX = "^\\d+$";
    private static final String NEW_LINE = "\n";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue() {
        System.out.println(NEW_LINE + WINNING_LOTTO_MESSAGE);
        String[] winningLottoInput = Console.readLine().split(",");
        List<Integer> winningLotto = new ArrayList<>();

        for (String number : winningLottoInput) {
            validate(number);

            winningLotto.add(Integer.parseInt(number));
        }

        return winningLotto;
    }

    public void validate(String inputValue) {
        validateEmpty(inputValue);
        validateNonNumeric(inputValue);
    }

    private void validateEmpty(String inputValue) {
        if (inputValue.trim().isEmpty()) {
            throw new EmptyException();
        }
    }

    private void validateNonNumeric(String inputValue) {
        if (!inputValue.matches(INTEGER_REGEX)) {
            throw new NonNumericException();
        }
    }
}
