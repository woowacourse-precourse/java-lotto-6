package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELEMETER = ",";
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NON_NUMERIC_INPUT_ERROR_MESSAGE = "[ERROR] 숫자 이외의 문자 입력은 불가합니다.";
    
    public int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(getUserInput());
    }
    
    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return Arrays.stream(splitInput(getUserInput()))
                .map(this::convertToInt)
                .collect(Collectors.toList());
    }
    
    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return convertToInt(getUserInput());
    }
    
    private int convertToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }
    
    private String getUserInput() {
        return Console.readLine();
    }
    
    private String[] splitInput(String userInput) {
        return userInput.split(DELEMETER);
    }
}
