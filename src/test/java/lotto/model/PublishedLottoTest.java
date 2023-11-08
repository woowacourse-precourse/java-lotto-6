package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PublishedLottoTest {
    private static final Integer THREE_LOTTO = 3000;

    @DisplayName("주어지는 정수로 생성되는 객체 확인")
    @Test
    void getInstanceTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    PublishedLotto testInstance = PublishedLotto.getInstance(THREE_LOTTO);

                    String expected = "[1, 2, 3, 4, 5, 6]\n[40, 41, 42, 43, 44, 45]\n[10, 15, 20, 30, 35, 40]";

                    assertEquals(expected, testInstance.toString());
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(45, 44, 43, 42, 41, 40),
                List.of(10, 20, 30, 40, 15, 35)
        );
    }

    @Test
    void getCount() {
        PublishedLotto testInstance = PublishedLotto.getInstance(THREE_LOTTO);

        Integer expected = 3;

        assertEquals(expected, testInstance.getCount());
    }
}