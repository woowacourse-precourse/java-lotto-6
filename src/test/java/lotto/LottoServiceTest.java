package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoStorage lottoStorage;
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoStorage = new LottoStorage();
        lottoService = new LottoService(lottoStorage);
    }

    @Test
    @DisplayName("금액에 맞는 로또 수 만큼 로또를 생성한다.")
    void test_GenerateLottosSuccessful() {
        //given
        BigDecimal payment = new BigDecimal(5000);

        //when
        lottoService.generateLotteries(payment);

        //then
        List<Lotto> lotteries = lottoStorage.findAllLotteries();
        assertThat(lotteries).hasSize(5);
    }
}
