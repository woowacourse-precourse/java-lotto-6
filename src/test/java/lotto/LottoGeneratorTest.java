package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("돈이 주어지면 로또가 원하는 개수만큼 발급됩니다.")
    @Test
    void issueLottoTickets(){
        // given
        Money money = new Money("3000");
        // when
        List<Lotto> lottos = LottoGenerator.issueLottoTickets(money);
        // then
        assertThat(lottos.size()).isEqualTo(3);
    }
}
