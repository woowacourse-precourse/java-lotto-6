package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningBundleTest {

    @Test
    void 당첨_번호와_보너스_번호가_일치하면_IllegalStateException_예외처리_검증() {
        //given
        String userInput = "1,2,3,4,5,6";
        List<WinningNumber> winningNumbers = Arrays.stream(userInput.split(","))
                .map(s -> WinningNumber.from(s)).toList();

        List<Integer> winningBundle = WinningBundle.from(winningNumbers).getWinningBundle();

        //when
        assertThatThrownBy(() -> BonusNumber.of("5", winningBundle))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 일치할 수 없습니다.");
    }
}