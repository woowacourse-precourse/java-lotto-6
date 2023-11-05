package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MSG_ASKING_BUDGET = "구입금액을 입력해 주세요.";
    private static final String MSG_ASKING_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MSG_ASKING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public String getUserInput() {
        return Console.readLine().trim();
    }

    public int printAskingBudget() {
        System.out.println(MSG_ASKING_BUDGET);
        return Integer.parseInt(getUserInput());
    }

    public List<Integer> printAskingWinningNumbers() {
        System.out.println(MSG_ASKING_WINNING_NUMBERS);
        return parseStringToList(getUserInput());
    }

    private List<Integer> parseStringToList(String userInput) {
        return Arrays.stream(userInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int printAskingBonusNumber() {
        System.out.println(MSG_ASKING_BONUS_NUMBER);
        return Integer.parseInt(getUserInput());
    }

    public void close() {
        Console.close();
    }
}
