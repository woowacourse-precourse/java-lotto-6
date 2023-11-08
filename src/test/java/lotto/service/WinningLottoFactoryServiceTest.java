package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoFactoryServiceTest {
    WinningLottoFactoryService winningLottoFactoryService = WinningLottoFactoryServiceImpl.getInstance();

    @Test
    @DisplayName("당첨 로또 생성 테스트")
    void winningLottoWithSort() {
        String inputNumber = "3,1,2,5,4,6";
        Lotto lotto = winningLottoFactoryService.winningLotto(inputNumber);
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 1; i <= numbers.size(); i++) {
            assertThat(numbers.get(i-1)).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("당첨 로또 개수 예외 테스트")
    void winningLottoFailWithSizeOver() {
        String inputNumber = "1,2,3,4,5,6,7,8";
        assertThatThrownBy(() -> winningLottoFactoryService.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 개수 예외 테스트")
    void winningLottoFailWithSizeUnder() {
        String inputNumber = "1,2,3,4,5";
        assertThatThrownBy(() -> winningLottoFactoryService.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자 포멧 예외 테스트")
    void winningLottoFailWithFormat() {
        String inputNumber = "1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> winningLottoFactoryService.winningLotto(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}