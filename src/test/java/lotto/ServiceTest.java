package lotto;

import lotto.Service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ServiceTest {
    private LottoService gameService;

    @BeforeEach
    void set() {
        gameService = new LottoService();
    }

    @DisplayName("구입한 금액을 입력받아 로또 개수를 구한다")
    @Test
    void countingLottoByAmountTest() {
        int result = gameService.countingLottoByAmount(8000);
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("구입한 금애이 1000원으로 나누어떨어지지 않으면 예외 처리한다.")
    @Test
    void countingLottoByAmountExceptionTest() {
        assertThatThrownBy(() -> gameService.countingLottoByAmount(8001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교해 같은 숫자 개수를 구한다")
    @Test
    void createLottoNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto win = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        int result = gameService.sameNumberCount(lotto, win);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("5개만 같다면, 보너스 번호와 같은지 확인")
    @Test
    void isSameBonusNumberTest() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 6, 5, 4));
        Lotto lotto = new Lotto(list);
        assertThat(gameService.isSameBonusNumber(lotto, 3))
                .isTrue();
        assertThat(gameService.isSameBonusNumber(lotto, 7))
                .isFalse();
    }

    @DisplayName("당첨 개수 List를 가지고 당첨 금액을 구하는 기능")
    @Test
    void rateOfReturnTest() {
        String result = gameService.rateOfReturn(8000, 5000);
        assertThat(result).isEqualTo("62.5");
    }


}
