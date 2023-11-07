package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static String INPUT_STYLE_ERROR_INT = "[ERROR] 공백을 포함하지 않는 한 개의 숫자를 입력해야 합니다.";
    private static String INPUT_STYLE_ERROR_STRING = "[ERROR] 공백을 포함하지 않는 숫자를 입력해야 합니다.";

    public List<Integer> translatePlayerInputStringToInt(String playerInputString){
        try {
            List<String> playerInput = new ArrayList<>(Arrays.asList(playerInputString.split(",")));
            List<Integer> playerInputInt = playerInput.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            return playerInputInt;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_STYLE_ERROR_STRING);
        }
    }

    public int stringToInteger(String playerInputNum) {
        try{
            return Integer.parseInt(playerInputNum);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(INPUT_STYLE_ERROR_INT);
        }
    }
}
