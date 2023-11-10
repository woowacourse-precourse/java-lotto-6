package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers();
        winningNumbers.setMainNumbers(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setBonusNumber(7);
    }

    @DisplayName("당첨 번호 여부 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false", "45,false"})
    void isWinningNumber(int number, boolean expected) {
        assertThat(winningNumbers.isMainNumber(number)).isEqualTo(expected);
    }

    @DisplayName("보너스 번호 여부 테스트")
    @ParameterizedTest
    @CsvSource({"1,false", "7,true", "45,false"})
    void isBonusNumber(int number, boolean expected) {
        assertThat(winningNumbers.isBonusNumber(number)).isEqualTo(expected);
    }

}
