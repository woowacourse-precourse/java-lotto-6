package lotto.test;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.MockedStatic.Verification;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

public class LottoAssertions {
    private static final Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(1L);
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    private LottoAssertions() {
    }

    public static void assertSimpleTest(final Executable executable) {
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable);
    }

    public static void assertRandomNumberInListTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInList(anyList()),
            executable,
            value,
            values
        );
    }

    public static void assertRandomNumberInRangeTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
            executable,
            value,
            values
        );
    }

    public static void assertRandomUniqueNumbersInRangeTest(
        final Executable executable,
        final List<Integer> value,
        final List<Integer>... values
    ) {
        assertRandomTest(
            () -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()),
            executable,
            value,
            values
        );
    }

    private static <T> void assertRandomTest(
        final Verification verification,
        final Executable executable,
        final T value,
        final T... values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }
}
