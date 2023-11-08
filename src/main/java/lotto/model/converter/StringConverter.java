package lotto.model.converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * String을 다른 자료형으로 형변환하는 제너릭 interface다.
 *
 * @param <T> String에서 변환될 자료형
 */
public interface StringConverter<T> {
    /**
     * 단일 String을 일치하는 타입으로 변환한다.
     *
     * @param input 변환할 String
     * @return T 자료형으로 변환된 객체
     */
    T toType(String input);

    /**
     * String의 List를 T 타입의 List로 변환한다.
     *
     * @param inputList 변환할 String List
     * @return T 자료형으로 변환된 List
     */
    default List<T> toTypeList(List<String> inputList) {
        return inputList.stream()
                .map(this::toType)
                .collect(Collectors.toList());
    }
}
