package lotto.utils;

import lotto.view.InputView;

public class converterStringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("숫자로 변환할 수 없습니다."), e);
        }
    }
}
