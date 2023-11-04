package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListDataTypeConverterTest {

    @Test
    @DisplayName("List 데이터 타입이 Integer -> String으로 변경된다.")
    void convertListDataTypeIntegerToString() {
        //given
        List<Integer> integers = List.of(1,2,3,4);

        //when
        List<String> strings = ListDataTypeConverter.integerToString(integers);

        //then
        Assertions.assertTrue(strings.stream().allMatch(item -> item instanceof String));
    }

}