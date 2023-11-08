package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.ConstantNum.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class UserNumbersTest {
    private List<Integer> numbers;
    private List<Integer> wrongNumbers;

    private UserNumbers userNumbers;

    @BeforeEach
    void setUp() {
        // given
        numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            numbers.add(i);
        }
        wrongNumbers = new ArrayList<>(numbers);
    }

    @Test
    @DisplayName("주어진 번호의 수가 범위를 벗어나는 경우 예외 처리 후 재입력 동작")
    void Should_ReEnter_When_NumberIsOutOfRange() {
        // given
        wrongNumbers.set(wrongNumbers.size() - 1, LOTTO_NUMBER_MAX.getNum() + 1);

        // when
        try (final MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
            consoleMock.when(() -> readLine()).thenReturn(
                    numbers.toString().substring(1, numbers.toString().length() - 1).replaceAll("\\s", ""));
            userNumbers = new UserNumbers(wrongNumbers);
        }

        // then
        assertThat(userNumbers.getNumbers()).usingRecursiveComparison().isEqualTo(numbers);
    }

    @Test
    @DisplayName("주어진 당첨 번호가 중복될 경우 예외 처리 후 재입력 동작")
    void Should_ReEnter_When_NumberIsDuplicated() {
        // given
        wrongNumbers.set(wrongNumbers.size() - 1, LOTTO_NUMBER_MIN.getNum());

        // when
        try (final MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
            consoleMock.when(() -> readLine()).thenReturn(
                    numbers.toString().substring(1, numbers.toString().length() - 1).replaceAll("\\s", ""));
            userNumbers = new UserNumbers(wrongNumbers);
        }

        // then
        assertThat(userNumbers.getNumbers()).usingRecursiveComparison().isEqualTo(numbers);
    }
}