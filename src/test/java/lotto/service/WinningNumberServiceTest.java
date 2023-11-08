package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberServiceTest {
    private WinningNumberService winningNumberService;

    @BeforeEach
    void initTest() {
        winningNumberService = new WinningNumberService();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @ParameterizedTest
    @DisplayName("당첨번호를 가져올 수 있다.")
    @MethodSource("fetchValidatedBonusTestValue")
    void fetchValidatedBonusTest(String readLine, List<Integer> expect) {
        System.setIn(createInputStream(readLine));
        WinningLotto winningLotto = winningNumberService.fetchValidatedWinningNumber();
        Assertions.assertThat(winningLotto.getNumbers()).isEqualTo(expect);
    }

    private static Stream<Arguments> fetchValidatedBonusTestValue() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("30,41,42,43,44,45", List.of(30, 41, 42, 43, 44, 45))
        );
    }

    private InputStream createInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
