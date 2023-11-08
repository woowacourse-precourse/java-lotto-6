package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.domain.constant.StringConstant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class OutputServiceTest extends NsTest {
    private static final Duration OUTPUT_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @DisplayName("OutputService의 모든 메서드가 출력값 형식에 맞도록 출력한다")
    @Test
    void outputServiceTest() {
        assertOutputTest(
                () -> {
                    run(TEST_STANDARD_EXPENSE, TEST_STANDARD_WINNINGLOTTO, TEST_STANDARD_BONUSNUM);
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3000000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    private static void assertOutputTest(
            final Executable executable,
            final List value,
            final List... values
    ) {
       assertTimeoutPreemptively(OUTPUT_TEST_TIMEOUT, () -> {
           try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
               mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                       .thenReturn(value, Arrays.stream(values).toArray());
               executable.execute();
           }
       });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}