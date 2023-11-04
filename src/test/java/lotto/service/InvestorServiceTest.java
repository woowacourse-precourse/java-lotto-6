package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class InvestorServiceTest {

    @Test
    @DisplayName("서비스 정상 생성 테스트")
    void createInvestorServiceTest() {
        // given
        String investorInput = "5000";

        // when & then
        assertDoesNotThrow(() -> InvestorService.createDefault(investorInput));
    }

    @Test
    @DisplayName("로또 구입 테스트")
    void buyLottoTest() {
        // given
        String investorInput = "5000";
        InvestorService investorService = InvestorService.createDefault(investorInput);

        // when
        List<Lotto> boughtLottos = investorService.buyLottos();

        // then
        assertThat(boughtLottos.size()).isEqualTo(5);
    }
}
