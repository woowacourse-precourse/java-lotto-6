package service;

import lotto.domain.Lotto;
import lotto.service.WinningLottoFactory;
import lotto.service.WinningLottoFactoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoFactoryTest {
    WinningLottoFactory winningLottoFactory = WinningLottoFactoryImpl.getInstance();

    @Test
    @DisplayName("당첨 로또 생성 테스트")
    void winningLotto() {
        String inputNumber = "1,2,3,4,5,6";
        Lotto lotto = winningLottoFactory.winningLotto(inputNumber);
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);
        assertThat(numbers.contains(4)).isEqualTo(true);
        assertThat(numbers.contains(5)).isEqualTo(true);
        assertThat(numbers.contains(6)).isEqualTo(true);
    }

    @Test
    @DisplayName("당첨 로또 생성 테스트 - 정렬 여부")
    void winningLottoWithSort() {
        String inputNumber = "3,1,2,5,4,6";
        Lotto lotto = winningLottoFactory.winningLotto(inputNumber);
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 1; i <= numbers.size(); i++) {
            assertThat(numbers.get(i-1)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("당첨 로또 중복 숫자 예외 테스트")
    void winningLottoFailWithDup() {
        String inputNumber = "1,2,3,4,5,5";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 개수 예외 테스트")
    void winningLottoFailWithSizeOver() {
        String inputNumber = "1,2,3,4,5,6,7,8";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 개수 예외 테스트")
    void winningLottoFailWithSizeUnder() {
        String inputNumber = "1,2,3,4,5";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자 범위 초과 예외 테스트")
    void winningLottoFailWithRangeOver() {
        String inputNumber = "1,2,3,4,5,100";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자 범위 미만 예외 테스트")
    void winningLottoFailWithRangeUnder() {
        String inputNumber = "1,2,3,4,5,0";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자 포멧 예외 테스트")
    void winningLottoFailWithFormat() {
        String inputNumber = "1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> winningLottoFactory.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
