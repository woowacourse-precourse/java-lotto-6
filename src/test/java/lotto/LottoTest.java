package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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


    // 아래에 추가 테스트 작성 가능
    @Test
    void 구입금액이_1000원으로_나누어떨어지지_않으면_예외를_발생시킨다() {
        int invalidAmount = 1500;

        assertThatThrownBy(() -> Application.makeTicket(invalidAmount) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    void 구입금액에_해당하는_로또를_발행한다() {
        int amount = 5000;

        assertThat(Application.makeTicket(amount)).isEqualTo(5);

    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}