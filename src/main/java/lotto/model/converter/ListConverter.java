package lotto.model.converter;

import java.util.Arrays;
import java.util.List;

/**
 * {@code StringConverter} 인터페이스를 구현한다.
 * String을 List로 변환한다.
 */
public class ListConverter implements StringConverter<List<String>> {
    /**
     * String을 split하여 List로 변환한다.
     *
     * @param input 변환할 String
     * @return 주어진 String을 split하여 List로 변환한 값
     */
    @Override
    public List<String> toType(String input) {
        return Arrays.stream(input.split(",", -1)).toList();
    }
}
