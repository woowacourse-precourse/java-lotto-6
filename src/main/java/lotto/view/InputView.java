package lotto.view;

import static lotto.constant.ViewConstant.COMMA;
import static lotto.constant.ViewConstant.INPUT_BONUS_NUMBER_MENT;
import static lotto.constant.ViewConstant.INPUT_FEE_MENT;
import static lotto.constant.ViewConstant.INPUT_WINNER_NUMBERS_MENT;
import static lotto.exception.Message.INPUT_BONUS_NUMBERS_ERROR;
import static lotto.exception.Message.INPUT_LOTTO_NUMBERS_ERROR;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final ConsoleService consoleService;

    public InputView(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public long number() {
        try {
            System.out.println(INPUT_FEE_MENT);
            return Long.parseLong(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBERS_ERROR);
        }
    }

    public List<Integer> numbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MENT);
        return Arrays.stream(consoleService.readLine().split(COMMA)).map(Integer::parseInt).toList();
    }

    public int bonus() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MENT);
            return Integer.parseInt(consoleService.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBERS_ERROR);
        }
    }
}
