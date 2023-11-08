package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTicketGeneratorTest {

    LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    @DisplayName("구매한 금액에 따른 발행 로또 개수가 맞는지 확인한다.")
    @Test
    void createRandomLottoCount() {
        String buyLottoAmount = "5000";

        List<List<Integer>> lottoTickets = lottoTicketGenerator.createRandomLottoTickets(buyLottoAmount);

        Assertions.assertThat(lottoTickets.size()).isEqualTo(5);
    }
}