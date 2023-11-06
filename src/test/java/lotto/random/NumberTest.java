package lotto.random;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("랜덤 번호가 1~45 범위에 중복 없이 6 개의 숫자 리스트를 반환한다.")
    @ValueSource()
    @Test
    void returnUniqueLottoGenerator() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                assertEquals(Number.LottoGenerator(), List.of(8, 21, 23, 41, 42, 43));
            },
        List.of(8, 21, 23, 41, 42, 43)
        );
    }
}