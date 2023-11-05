package study;

import java.util.Arrays;
import lotto.constant.PrizeMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EnumTest {

    @DisplayName("Enum.values() 호출 시 enum 선언 순서대로 출력된다.")
    @Test
    void printAllEnumValues() {
        System.out.println(Arrays.stream(PrizeMessage.values()).toList());
    }

}
