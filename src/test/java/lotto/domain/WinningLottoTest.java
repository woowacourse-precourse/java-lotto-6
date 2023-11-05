package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto();

    @DisplayName("쉼표로 구분된 숫자를 입력받아 숫자 배열로 반환한다.")
    @Test
    void setWinningNumberToArray() {
        String number = "1,2,3,4,5,6";
        List<Integer> numbers = winningLotto.setWinningLotto(number);

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]"
        );
    }
}