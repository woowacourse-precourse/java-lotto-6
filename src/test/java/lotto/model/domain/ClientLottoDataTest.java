package lotto.model.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClientLottoDataTest {
    ClientLottoData clientLottoData;

    @BeforeEach
    void createClientLottoData() {
        clientLottoData = new ClientLottoData();
    }

    @AfterEach
    void removeClientLottoData() {
        clientLottoData = null;
    }

    @Test
    void setLottoTicketNumber() {
        clientLottoData.setLottoTicketNumber(1000);
        Assertions.assertThat(clientLottoData.getLottoTicketCount()).isEqualTo(1);
    }

    @Test
    void setLottoTicket() {
        clientLottoData.setLottoTicket(20);
        List<Lotto> lottos = clientLottoData.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> set = new HashSet<>(numbers);
            Assertions.assertThat(set.size()).isEqualTo(6);
        }
    }

    @Test
    void setIncome() {
        // given
        clientLottoData.setPrice(8000);
        List<RankTable> rankTables = List.of(RankTable.FIVE, RankTable.BONUS, RankTable.THREE);
        clientLottoData.setMatchLottoCalculate(rankTables);
//31505000
        double income = clientLottoData.setIncome();
        Assertions.assertThat(income).isEqualTo(393812.5);
    }
}