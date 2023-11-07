package lotto.domain;

import java.util.List;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class WinningNumbersTest {

    @DisplayName("winningNumbers 로또번호와 비교 정상 작동 확인 테스트")
    @Test
    void compareWinningNumbers_EqualCount_Success() {

        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        //when
        long result = winningNumbers.compareWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(6);

    }

    @DisplayName("winningNumbers 로또번호와 비교 실패 테스트")
    @Test
    void compareWinningNumbers_DifferentCount_Success() {

        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        //when
        long result = winningNumbers.compareWinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        //then
        assertThat(result).isNotNull();
        assertThat(result).isNotEqualTo(6);

    }


}
