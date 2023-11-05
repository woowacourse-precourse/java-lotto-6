package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public List<Integer> translatePlayerInputStringToInt(String playerInputString){
        List<String> playerInput = new ArrayList<>(Arrays.asList(playerInputString.split(",")));
        List<Integer> playerInputInt=playerInput.stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList());

        return playerInputInt;
    }
    public int stringToInteger(String playerInputNum) {
        return Integer.parseInt(playerInputNum);
    }
}
