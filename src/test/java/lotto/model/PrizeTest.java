package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    private final Lotto lotto = new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));

    @DisplayName("로또 당첨 번호 객체 생성을 테스트한다.")
    @Test
    void createLottoByValidNumber() {
        LottoNumber bonus = LottoNumber.getInstance(10);
        Prize prize = Prize.of(lotto, bonus);
        assertThat(prize).isNotNull();
    }

    @DisplayName("로또 당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        LottoNumber bonus = LottoNumber.getInstance(3);
        assertThatThrownBy(() -> Prize.of(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}