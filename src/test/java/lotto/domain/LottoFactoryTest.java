package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @DisplayName("로또 숫자 발행 수 체크")
    @Test
    void checkNumberOfPublishedLotto() {
        final Integer NUMBER_OF_LOTTOS = 18;
        LottoTicket lottoTicket = LottoFactory.makeNewLottoTicket(NUMBER_OF_LOTTOS);

        Integer lottoCount = lottoTicket.getHowManyLotto();
        assertThat(lottoCount.equals(NUMBER_OF_LOTTOS));
    }

}