package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스 넘버가 이미 당첨번호에 존재할 시 예외가 발생한다.")
    void validateDuplication() {
        assertThatThrownBy(() -> winningNumbers.validateDuplication(1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또의 일치하는 번호의 갯수를 센다.")
    @CsvSource(value = {"1,2,3,4,5,6,6","1,2,3,4,5,10,5","1,2,3,4,10,11,4"})
    void countMatchedNumber(int num1, int num2,int num3,int num4,int num5,int num6, int expect) {
        //given
        Lotto lotto = new Lotto(List.of(num1, num2, num3, num4, num5, num6));

        //when

        //then
        assertThat(winningNumbers.countMatchedNumber(lotto)).isEqualTo(expect);

    }
}