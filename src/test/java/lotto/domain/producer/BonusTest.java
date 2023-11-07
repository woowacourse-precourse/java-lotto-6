package lotto.domain.producer;

import lotto.domain.common.Lotto;
import lotto.exception.Bonus.BonusDuplicationException;
import lotto.exception.Bonus.BonusNotInRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BonusTest {

    private final Integer ONE = 1;
    private final Integer TWO = 2;
    private final Integer THREE = 3;
    private final Integer FOUR = 4;
    private final Integer FIVE = 5;
    private final Integer SIX = 6;

    private final Lotto producerLotto = new Lotto(List.of(ONE, TWO, THREE, FOUR, FIVE, SIX));

    private final Integer MINUS_ONE = -1;
    private final Integer FOURTY_SIX = 46;
    private final Integer ONE_HUNDRED = 100;

    @DisplayName("로또 당첨 보너스 번호는 로또 당첨 번호와 중복될 수 없음")
    @Test
    void testBonusDuplication() {
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, ONE)).isInstanceOf(BonusDuplicationException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, TWO)).isInstanceOf(BonusDuplicationException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, THREE)).isInstanceOf(BonusDuplicationException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, FOUR)).isInstanceOf(BonusDuplicationException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, FIVE)).isInstanceOf(BonusDuplicationException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, SIX)).isInstanceOf(BonusDuplicationException.class);
    }

    @DisplayName("로또 당첨 보너스 번호는 1 이상 45 이하의 숫자 중에서 입력해야 함")
    @Test
    void testBonusNotInRange() {
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, MINUS_ONE)).isInstanceOf(BonusNotInRangeException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, FOURTY_SIX)).isInstanceOf(BonusNotInRangeException.class);
        Assertions.assertThatThrownBy(() -> new Bonus(producerLotto, ONE_HUNDRED)).isInstanceOf(BonusNotInRangeException.class);
    }
}
