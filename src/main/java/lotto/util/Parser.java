package lotto.util;

import lotto.domain.constants.CharacterSetting;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> inputToStringList(String playerInput) {
        return Arrays.stream(playerInput.split(CharacterSetting.INPUT_DELIMITER.getCharacter())).toList();
    }

    public List<Integer> stringListToNumberList(List<String> inputValues) {
        return inputValues.stream()
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    public int inputToNumber(String playerInput) {
        return Integer.parseInt(playerInput);
    }

    public String doubleToFirstDecimalPlace(double rate) {
        return String.format("%.1f", rate);
    }
}
