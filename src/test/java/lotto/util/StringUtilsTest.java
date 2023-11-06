package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void 콤마로_분리_및_공백_제거_테스트() {
        List<String> splitNumbers = StringUtils.splitByCommaAndTrim("1 ,  2  ,3,4 ,25,  5");
        assertEquals(List.of("1", "2", "3", "4", "25", "5"), splitNumbers);
    }
}
