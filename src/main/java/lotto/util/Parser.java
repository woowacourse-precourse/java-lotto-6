package lotto.util;

import lotto.domain.constants.CharacterSetting;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private List<String> inputToStringList(String playerInput) {
        return Arrays.stream(playerInput.split(CharacterSetting.INPUT_DELIMITER.getCharacter())).toList();
    }

    public List<Integer> stringListToNumberList(String playerInput) {
        return inputToStringList(playerInput).stream()
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    public int inputToNumber(String playerInput) {
        return Integer.parseInt(playerInput);
    }

    public String doubleToSecondDecimalString(double rate) {
        return String.format("%.1f", rate);
    }
}
