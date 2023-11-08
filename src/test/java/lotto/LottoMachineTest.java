package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    private LottoMachine lottoMachine;
    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoMachine = new LottoMachine(lottoNumberGenerator);
    }

    @DisplayName("지정된 금액만큼 로또를 발행한다")
    @Test
    void issueLottoTickets() {
        int purchaseAmount = 5000;
        List<Lotto> lottoTickets = lottoMachine.issueLottoTickets(purchaseAmount);

        assertAll(
                () -> assertThat(lottoTickets).isNotNull(),
                () -> assertThat(lottoTickets).hasSize(purchaseAmount / 1000),
                () -> assertThat(lottoTickets).allMatch(lotto -> lotto.getNumbers().size() == 6),
                () -> assertThat(lottoTickets).allMatch(lotto -> lotto.getNumbers().stream()
                        .allMatch(number -> number >= 1 && number <= 45))
        );
    }

    @DisplayName("구입 금액이 1000원 미만일 때 로또를 발행하지 않는다")
    @Test
    void doesNotIssueTicketForLessThanPriceOfOneLotto() {
        int purchaseAmount = 500; // 1000원 미만 금액
        List<Lotto> tickets = lottoMachine.issueLottoTickets(purchaseAmount);
        assertThat(tickets).isEmpty(); // 로또 티켓이 발행되지 않아야 함
    }
}
