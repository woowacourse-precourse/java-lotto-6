package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputWinningNumberView {
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    public List<Integer> inputWinningNumbers(){
        String input = inputWinningNumber();
        validateInput(input);
        return createWinningNumbers(input);
    }

    private String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }


    private List<Integer> createWinningNumbers(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateInput(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 6개의 유효한 값을 입력하세요.");
        }
    }
}
