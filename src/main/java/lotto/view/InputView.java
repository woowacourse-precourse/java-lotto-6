package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.*;

public class InputView {
    public static final String INPUT_LOTTO_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String SPLITTER = ",";

    public int getLottoBudget() {
        System.out.println(INPUT_LOTTO_BUDGET_MESSAGE);
        int money = turnToInteger(Console.readLine());

        validateInputBudget(money);
        return money;
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);

        String input = Console.readLine();
        String[] nums = input.split(SPLITTER);
        List<Integer> inputNumber = new ArrayList<>();

        for (String num : nums) {
            int number = turnToInteger(num);
            inputNumber.add(number);
        }

        return inputNumber;
    }

    public int turnToInteger(String money) {
        try {
            return Integer.parseInt(money.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INTEGER_TYPE_ERROR);
        }
    }

    public void validateInputBudget(int money) {
        if (money <= MIN_PRICE || MAX_PRICE < money) {
            throw new IllegalArgumentException(ERROR_LOTTO_BUDGET_RANGE);
        }

        if (money % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_LOTTO_BUDGET_PRICE);
        }
    }

    public int getWinningLottoBonusNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_LOTTO_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }


}
