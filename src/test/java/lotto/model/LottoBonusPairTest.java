package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusPairTest {
    private static final Lotto TEST_LOTTO_INSTANCE = new Lotto(List.of(1,2,3,4,5,6));
    private static final Integer VALID_BONUS_NUMBER = 7;
    private static final Integer INVALID_BONUS_NUMBER = 6;
    private static final Integer THREE_LOTTO = 3000;

    @DisplayName("주어지는 Lotto 객체와 정수로 생성되는 객체 확인")
    @Test
    void getInstanceTest() {
        LottoBonusPair testInstance = LottoBonusPair.getInstance(TEST_LOTTO_INSTANCE, VALID_BONUS_NUMBER);

        String expected = "당첨 번호 : [1, 2, 3, 4, 5, 6]\n보너스 번호 : 7";

        assertEquals(expected, testInstance.toString());
    }

    @DisplayName("보너스 번호가 당첨 번호와 겹치는 경우 예외 처리 테스트")
    @Test
    void getInstanceExceptionTest() {
        assertThatThrownBy(() -> LottoBonusPair.getInstance(TEST_LOTTO_INSTANCE, INVALID_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("보너스 번호가 포함될 수 없습니다.");
    }

    @DisplayName("getResult 메서드 작동 확인 테스트")
    @Test
    void getResults() {
        LottoBonusPair testInstance = LottoBonusPair.getInstance(TEST_LOTTO_INSTANCE, VALID_BONUS_NUMBER);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    PublishedLotto testPublishedInstance = PublishedLotto.getInstance(THREE_LOTTO);

                    List<Integer> expected = List.of(1, 2, 4);

                    assertEquals(expected, testInstance.getResults(testPublishedInstance));
                },
                List.of(1,2,3,4,5,6),
                List.of(2,3,4,5,6,7),
                List.of(4,5,6,7,8,9)
        );
    }
}