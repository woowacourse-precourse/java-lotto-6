package lotto.service;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculateServiceTest {
    private LottoCalculateService lottoCalculateService = new LottoCalculateService();

    @DisplayName("수익률 계산 테스트")
    @Test
    public void getYieldOfLottoTest() {
        // given
        User user = new User(8000);
        int totalPrice = 5000;
        // when
        String result = lottoCalculateService.getYieldOfLotto(user, totalPrice);
        // then
        assertThat(result).isEqualTo("62.5");
    }
}
