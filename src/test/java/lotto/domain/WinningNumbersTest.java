package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class WinningNumbersTest {
    private List<Integer> winning;
    private List<Integer> wrong;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        // given
        winning = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            winning.add(i);
        }
        wrong = new ArrayList<>(winning);
    }

    @Test
    @DisplayName("주어진 번호의 개수, 범위가 일치할 경우 정상 동작")
    void Should_Success_When_ValidWinningNumberCntAndRange() {
        // when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new WinningNumbers(winning);

        // then
        assertThatCode(throwingCallable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("주어진 당첨 번호의 개수가 일치하지 않을 경우 예외 처리 후 재입력 동작")
    void Should_ReEnter_When_WinningNumberCntIsNotMatch() {
        // given
        wrong.add(LOTTO_NUMBER_MIN.getNum());

        // when
        try (final MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
            consoleMock.when(() -> readLine()).thenReturn(
                    winning.toString().substring(1, winning.toString().length() - 1).replaceAll("\\s", ""));
            winningNumbers = new WinningNumbers(winning);
        }

        // then
        assertThat(winningNumbers.getNumbers()).usingRecursiveComparison().isEqualTo(winning);
    }
}