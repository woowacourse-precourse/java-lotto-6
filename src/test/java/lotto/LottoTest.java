package lotto;

import lotto.data.Lotto;
import lotto.provider.LottoProvider;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액 만큼의 로또를 구매한다.")
    @Test
    void 구입금액_만큼의_로또를_구매한다() {
        //given
        String purchaseAmount = "6000";
        LottoProvider lottoProvider = new LottoProvider();

        //when
        List<Lotto> lottos = lottoProvider.buyLottos(purchaseAmount);

        //then
        assertThat(lottos.size())
                .isEqualTo(6);
    }
}