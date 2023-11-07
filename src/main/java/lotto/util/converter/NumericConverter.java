package lotto.util.converter;

public class NumericConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String input) {
        return Integer.parseInt(input);
    }
}
