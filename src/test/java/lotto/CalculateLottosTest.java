package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.UserLottos;
import lotto.service.CalculateLottoPrizeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateLottosTest {
    @DisplayName("당첨 횟수 및 당첨금 계산하기")
    @Test
    void calculatePrize() {
        Map<Prize, Integer> countPrices = new HashMap<>();
        UserLottos userLottos = new UserLottos();

        countPrices.put(Prize.THREE, countPrices.getOrDefault(Prize.THREE, 0) + 1);
        countPrices.put(Prize.FIVE, countPrices.getOrDefault(Prize.FIVE, 0) + 1);
        countPrices.put(Prize.THREE, countPrices.getOrDefault(Prize.THREE, 0) + 1);
        userLottos.setWinningPrice(Prize.THREE.getCorrectPrize(4).getPrice());
        userLottos.setWinningPrice(Prize.THREE.getCorrectPrize(5).getPrice());

        assertThat(countPrices.get(Prize.THREE)).isEqualTo(2);
        assertThat(countPrices.get(Prize.FIVE)).isEqualTo(1);
        assertThat(userLottos.getWinningPrice()).isEqualTo(1550000);
    }

    @DisplayName("보너스 번호일 때 Prize 확인")
    @Test
    void checkBonusPrize() {
        int prizeCorrect = Prize.THREE.getCorrectPrize(7).getCorrecting();
        int prizePrice = Prize.THREE.getCorrectPrize(7).getPrice();

        assertThat(prizeCorrect).isEqualTo(7);
        assertThat(prizePrice).isEqualTo(30000000);
    }

    @DisplayName("로또 번호 5개 맞았을 때 불린 값 확인")
    @Test
    void checkCorrectFiveBoolean() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setBonusNum(7);
        Lotto userLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        CalculateLottoPrizeService service = new CalculateLottoPrizeService();

        boolean isFive = service.isCorrectedFive(userLotto.getNumbers(), lotto, 5);
        boolean isBonus = service.isCorrectedFiveWithBonus(userLotto.getNumbers(), lotto, 5);

        assertThat(isFive).isFalse();
        assertThat(isBonus).isTrue();
    }
}
