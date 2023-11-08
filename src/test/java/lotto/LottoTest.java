package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호가 숫자 범위내에 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 111)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 보다 작으면 예외가 발생한다.")
    @Test
    void createLottoUnderThousand() {
        assertThatThrownBy(() -> new LottoPrice(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구입 금액이 1,000으로 나누어떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void createLottoDivideThousand() {
        assertThatThrownBy(() -> new LottoPrice(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}