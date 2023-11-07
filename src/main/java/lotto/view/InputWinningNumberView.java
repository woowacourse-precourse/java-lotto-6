package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputWinningNumberView {
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    private String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    private void validateInput(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값이 유효한 숫자가 아닙니다.");
        }
    }

    private List<Integer> createWinningNumbers(String input){
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
