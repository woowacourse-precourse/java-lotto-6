package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;


class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 46, -1})
    @DisplayName("보너스 번호 생성 예외처리 테스트")
    void createBonusNumberExceptionTest(int number) {
        //given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(winningNumber.getWinningNumber(), number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}