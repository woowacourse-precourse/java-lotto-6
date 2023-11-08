package lotto.domain;

import static lotto.constant.MessageConstants.MONEY_RANGE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @DisplayName("사용자의 입력 금액이 구매 단위와 다르면 예외가 발생한다")
    @Test
    void createWrongUnitMoney() {
        // given
        long money = 3300L;

        // when, then
        assertThatThrownBy(() -> new Member(money, new LottoGenerator(money).generateLottos()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_RANGE);
    }

    @DisplayName("입력 금액에 해당하는 수량의 로또를 가진다")
    @Test
    void getPurchasedLottoQuantity() {
        // given
        long money = 14000L;

        // when
        Member member = new Member(money, new LottoGenerator(money).generateLottos());

        // then
        assertThat(member.lottos().size()).isEqualTo(member.calculateQuantity());
    }

}
