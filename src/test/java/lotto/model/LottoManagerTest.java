package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @DisplayName("입력된 개수만큼 로또 객체를 생성한다.")
    @Test
    void createLottosAsManyAsTicketNumber() {
        int ticketNumber = 5;
        LottoGenerator generator = new LottoGenerator();
        LottoManager lottoManager = new LottoManager(generator,ticketNumber);

        lottoManager.generateLottos();

        assertThat(lottoManager
                .getLottos()
                .size())
                .isEqualTo(ticketNumber);
    }

}