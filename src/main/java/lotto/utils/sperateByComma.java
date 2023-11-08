package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class sperateByComma implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String target) {
        return Arrays.stream(target.split(",")).map(this::convertToNumber).collect(Collectors.toList());
    }

    private Integer convertToNumber(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("숫자로 변환할 수 없는 숫자가 포함되어있습니다."), e);
        }
    }
}
