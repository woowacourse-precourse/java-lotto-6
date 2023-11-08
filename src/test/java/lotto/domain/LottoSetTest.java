package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.util.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSetTest {

    private Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @ParameterizedTest
    @ValueSource(ints = {46, 0, -1})
    @DisplayName("보너스 번호 범위에 일치하지 않는 숫자가 있으면 예외가 발생한다.")
    void createOverRange(int number) {
        assertThatThrownBy(() -> new LottoSet(this.lotto,number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("중복되는 숫자가 있는지 확인한다.")
    void createDuplicate(int number) {
        assertThatThrownBy(() -> new LottoSet(this.lotto,number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 로또 숫자인지 확인한다.")
    void sameLottoNumber(){
        // given
        Ticket ticket = new Ticket(5000);
        List<Integer> tickets = RandomNumber.gernerate();
        LottoSet lottoSet = new LottoSet(this.lotto, 7);

        // when
        int count = lottoSet.sameLottoNumber(tickets);

        // then
        assertThat(count).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("같은 보너스 숫자인지 확인한다.")
    void sameBonusNumber(){
        // given
        Ticket ticket = new Ticket(5000);
        List<Integer> tickets = RandomNumber.gernerate();
        LottoSet lottoSet = new LottoSet(this.lotto, 7);

        // when
        int count = lottoSet.sameBonusNumber(tickets);

        // then
        assertThat(count).isGreaterThanOrEqualTo(0);
    }
}
