package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 객체 생성을 테스트한다.")
    @Test
    void createLottoByValidNumber() {
        Lotto lotto = new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(
                () -> new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 몇 개 일치하는지 테스트한다.")
    @Test
    void countMatchNumbers() {
        Lotto lotto = new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        LottoNumber bonus = LottoNumber.getInstance(10);
        Prize prize = Prize.of(lotto, bonus);

        int matchNumbers = lotto.countMatchNumbers(prize);

        assertThat(matchNumbers).isEqualTo(6);
    }

    @DisplayName("로또 보너스 번호가 일치하는지 테스트한다.")
    @Test
    void countMatchNumber() {
        Lotto lotto = new Lotto(Generator.generateIntegerToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        LottoNumber bonus = LottoNumber.getInstance(3);

        boolean matchBonus = lotto.isMatchNumber(bonus);

        assertThat(matchBonus).isTrue();
    }
}