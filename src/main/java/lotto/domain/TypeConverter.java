package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {

    private static final String COMMA = ",";

    public int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public List stringToList(String inputNumbers) {
        return Arrays.asList(inputNumbers.split(COMMA));
    }
}