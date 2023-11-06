package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberListParser implements Parser {
    @Override
    public List<Integer> StringToIntlistParsing(List<String> number) {
        List<Integer> intNumbers = new ArrayList<>();

        for (int i = 0; i < number.size(); i++) {
            intNumbers.add(Integer.parseInt(number.get(i)));
        }

        return intNumbers;
    }
}
