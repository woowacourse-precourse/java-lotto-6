package lotto.util.converter;

public class NumericConverter implements Converter<String,Integer>{
    @Override
    public Integer convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
