package lotto.service;

import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("로또 번호 몇개 맞았는지 테스트")
    @Test
    public void countUserNumbersContainLottoTest() {
        // given
        List<Integer> userNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        // when
        int count = lottoCalculateService.countUserNumbersContainLotto(userNumbers, lottoNumbers);
        // then
        assertThat(count).isEqualTo(3);
    }

}
