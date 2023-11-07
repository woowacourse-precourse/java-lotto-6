package study;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class AssertionsStudy {
    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(100L);


    public static void assertRandomUniqueNumbersInRangeTest(
            final Executable executable,
            final List<Integer> value,
            final List<Integer>... values
    ) {
        assertRandomTest (
                () -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()),
                executable,
                value,
                values
        );
    }

    private static <T> void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final T value,
            final T... values
    ) {
        org.junit.jupiter.api.Assertions.assertTimeoutPreemptively(
                RANDOM_TEST_TIMEOUT, () -> {
                    try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                        mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                        executable.execute();
                    }
                }
        );
    }
}
