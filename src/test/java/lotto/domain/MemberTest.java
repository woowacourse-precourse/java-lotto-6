package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validation.MemberValidationHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MemberTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1","2000:2","5000:5", "10000:10", "100000:100"}, delimiter = ':')
    @DisplayName("1000원 당 1장씩 로또를 구매한다.")
    void buyLotto(String amount, int count) {
        // given
        Member member = new Member();

        // when // then
        assertThat(member.buyLotto(amount).getLottoCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "100", "1001", "1010", "1100", "1101", "1110", "1111", "12345"})
    @DisplayName("로또 구매시 1000원 단위의 금액이 아니면 예외가 발생한다.")
    void buyLottoException(String amount) {
        // given
        Member member = new Member();

        // when // then
        assertThatThrownBy(() -> member.buyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MemberValidationHandler.INVALID_LOTTO_PURCHASE_UNIT_MESSAGE);
    }
}