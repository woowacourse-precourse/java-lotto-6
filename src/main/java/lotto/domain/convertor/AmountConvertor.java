package lotto.domain.convertor;

public class AmountConvertor implements Convertor<String, Integer> {
    @Override
    public Integer convert(String inputValue) {
        return convertInputValue(inputValue);
    }

    public int convertInputValue(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}