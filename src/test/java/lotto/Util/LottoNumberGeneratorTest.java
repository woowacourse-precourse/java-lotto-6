package lotto.Util;

import lotto.Domain.PlayerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("랜덤 로또 번호가 생성되는지 테스트한다.")
    @Test
    public void createLottoNumberTicketsTest() {
        int buyingPay = 10000;

        List<PlayerNumber> lottoTickets = LottoNumberGenerator.createLottoNumberTickets(buyingPay);

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @DisplayName("발행된 로또의 수량이 일치하는지 테스트한다.")
    @Test
    public void calculateNumberOfLottoTicketsTest() {
        int ticketCount = LottoNumberGenerator.calculateNumberOfLottoTickets(10000);

        assertThat(ticketCount).isEqualTo(10);
    }

    @DisplayName("각 수량별로 로또 번호가 6개씩 생성되는지 테스트한다.")
    @Test
    public void generateLottoTicketsTest() {
        List<PlayerNumber> lottoTickets = LottoNumberGenerator.generateLottoTickets(10);

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets.size()).isEqualTo(10);
        for (PlayerNumber playerNumber : lottoTickets) {
            List<Integer> lottoNumbers = playerNumber.getNumbers();
            assertThat(lottoNumbers).isSorted();
            assertThat(lottoNumbers).hasSize(6);
        }
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되는지 테스트한다.")
    @Test
    public void sortedListTest() {
        List<Integer> unsortedList = List.of(5, 3, 1, 6, 4, 2);

        List<Integer> sortedList = LottoNumberGenerator.sortedList(unsortedList);

        assertThat(sortedList).isSorted();
        assertThat(sortedList).containsExactly(1, 2, 3, 4, 5, 6);
    }
}

