package lotto.domain.lotto;

import lotto.domain.common.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        LottoMachine machine = LottoMachine.from(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("알 수 없는 로또 생성기로 로또 기계를 생성할 수 없다.")
    @Test
    void checkFactoryNonNull() {
        assertThatThrownBy(() -> LottoMachine.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또 생성기로 로또 기계를 생성할 수 없습니다.");
    }

    @DisplayName("주어진 금액에서 로또의 가격인 1000원을 나눈 수 만큼, 신규 로또를 발행한다.")
    @Test
    void issueWith() {
        LottoMachine machine = LottoMachine.from(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)));

        List<Lotto> lottos = machine.issueWith(Money.from(10000));

        assertThat(lottos).hasSize(10);
    }

    @DisplayName("주어진 돈이 1000원으로 나누어 떨어지지 않는 경우, 신규 로또를 발행할 수 없다.")
    @Test
    void issueWithInvalidMoney() {
        LottoMachine machine = LottoMachine.from(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> machine.issueWith(Money.from(1100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 1000원 단위로 입력해주세요.");
    }
}
