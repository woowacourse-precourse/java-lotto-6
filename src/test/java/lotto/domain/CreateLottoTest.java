package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateLottoTest {

    @Test
    @DisplayName("로또를 생성할 때 정상적인 개수의 로또 티켓이 생성되어야 함")
    void createLottoWithValidCount() {
        CreateLotto createLotto = new CreateLotto();
        int lottoCounts = 5;
        List<List<Integer>> lottoTickets = createLotto.createLotto(lottoCounts);
        assertThat(lottoTickets).hasSize(lottoCounts);
    }

    @Test
    @DisplayName("로또를 생성할 때 각 로또 티켓은 유효한 범위의 숫자로 이루어져야 함")
    void createLottoWithValidNumbers() {
        CreateLotto createLotto = new CreateLotto();
        int lottoCounts = 5;
        List<List<Integer>> lottoTickets = createLotto.createLotto(lottoCounts);
        for (List<Integer> ticket : lottoTickets) {
            assertThat(ticket).allMatch(number -> number >= 1 && number <= 45);
        }
    }

}
