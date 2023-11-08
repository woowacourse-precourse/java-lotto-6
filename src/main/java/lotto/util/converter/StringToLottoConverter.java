package lotto.util.converter;

import lotto.domain.Lotto;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class StringToLottoConverter implements Converter<String, Lotto> {

    private static final String SPLIT_UNIT = ",";

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == Lotto.class;
    }

    @Override
    public Lotto convert(String target) {
        String[] split = splitLine(target);
        List<Integer> numbers = toList(split);
        return new Lotto(numbers);
    }

    private String[] splitLine(String target) {
        Validator.checkComma(target);
        return target.split(SPLIT_UNIT);
    }

    private List<Integer> toList(String[] split) {
        List<Integer> temp = new ArrayList<>();
        for (String input : split) {
            int number = toInt(input);
            temp.add(number);
        }
        return temp;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getMessage());
        }
    }
}
