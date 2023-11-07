package lotto.util;

import lotto.constant.Phrases;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberListParser implements Parser {
    @Override
    public List<Integer> StringToIntlistParsing(List<String> number) {
        List<Integer> intNumbers = new ArrayList<>();

        for (int i = 0; i < number.size(); i++) {
            try {
                intNumbers.add(Integer.parseInt(number.get(i)));
            }catch (NumberFormatException numberFormatException){
                throw new IllegalArgumentException(Phrases.commaException);
            }

        }

        return intNumbers;
    }
}
