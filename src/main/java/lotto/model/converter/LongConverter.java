package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_TYPE;

/**
 * {@code StringConverter} 인터페이스를 구현한다.
 * String을 Long으로 변환한다.
 */
public class LongConverter implements StringConverter<Long> {
    /**
     * String을 Long으로 변환한다.
     *
     * @param input 변환할 String
     * @return 주어진 String을 Long으로 변환한 값
     * @throws IllegalArgumentException String이 Long으로 변환되지 않는 경우
     */
    @Override
    public Long toType(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }
}
