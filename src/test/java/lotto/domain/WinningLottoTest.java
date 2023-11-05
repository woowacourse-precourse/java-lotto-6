package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @DisplayName("로또번호와 당첨번호를 비교하여 일치하는 숫자 개수를 반환한다.")
    @Test
    void compareWinningNumberAndLottoNumber() {
        Lotto.createLotto(Arrays.asList(1,2,3,4,5,6));
        List<Integer> publishNumber = LottoStore.getInstance().getLotto().get(0).getNumbers();
        String number = "1,2,3,4,5,6";
        winningLotto.setWinningLotto(number);

        int count = winningLotto.compareLotto(publishNumber);

        assertThat(count).isEqualTo(6);
    }
}