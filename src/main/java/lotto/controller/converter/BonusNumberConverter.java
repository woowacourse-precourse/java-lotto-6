package lotto.controller.converter;

public class BonusNumberConverter implements Converter<Integer> {
    @Override
    public Integer convert(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
