package lotto.utils.converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private static final String COMMA = ",";

    private Converter() {
    }

    public static List<Integer> convertStringToList(String input) {
        List<Integer> convertedInput = new ArrayList<>();

        for (String splitedInput : input.split(COMMA)) {
            convertedInput.add(Integer.parseInt(splitedInput));
        }

        return convertedInput;
    }
}
