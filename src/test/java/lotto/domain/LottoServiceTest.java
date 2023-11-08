package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @DisplayName("구입금액을 입력하면 로또를 발행한다.")
    @Test
    void saveUserShouldCreateLottoTickets() {
        lottoService.saveUser(5000);
        List<Lotto> lottoTickets = lottoService.getLottoTickets();
        assertThat(lottoTickets).hasSize(5);
    }

    @DisplayName("구입금액을 입력하면 로또 개수를 저장한다.")
    @Test
    public void getCountShouldReturnLottoCount() {
        lottoService.saveUser(10000);
        int lottoCount = lottoService.getCount();
        assertThat(lottoCount).isEqualTo(10); // 10000원으로 10장의 로또를 구입
    }
}