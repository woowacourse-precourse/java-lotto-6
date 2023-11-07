package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구매한 금액에 따라 로또 발행")
    @Test
    void initLottoNumbers() {
        LottoService lottoService = new LottoService();
        int money = 10000;
        lottoService.initLottoNumbers(money);
        List<Lotto> lottoList = lottoService.getLottoList();
        assertThat(lottoList.size() == (money / 1000)).isTrue();
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void inputMoneyByWrongUnit () {
        LottoService lottoService = new LottoService();
        int money = 1234567;
        assertThatThrownBy(() -> {
            lottoService.initLottoNumbers(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}