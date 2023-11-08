package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_TYPE;

import java.util.List;

/**
 * {@code StringConverter} 인터페이스를 구현한다.
 * String을 Integer로 변환한다.
 */
public class IntegerConverter implements StringConverter<Integer> {
    /**
     * String을 Integer로 변환한다.
     *
     * @param input 변환할 String
     * @return 주어진 String을 Integer로 변환한 값
     * @throws IllegalArgumentException String이 Integer로 변환되지 않는 경우
     */
    @Override
    public Integer toType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    /**
     * String List를 Integer List로 변환한다.
     *
     * @param inputList 변환할 String List
     * @return 주어진 String List를 Integer List로 변환한 값
     */
    @Override
    public List<Integer> toTypeList(List<String> inputList) {
        return StringConverter.super.toTypeList(inputList);
    }
}
