package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    static List<Lotto> lottos;
    LottoService lottoService = new LottoService();

    @BeforeEach
    void setLottos() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
    }

    @DisplayName("구입 금액에 따른 로또 수량 확인")
    @Test
    void calcAmountTest() {
        int amount1 = lottoService.calcAmount(8000);
        int amount2 = lottoService.calcAmount(1000);
        int amount3 = lottoService.calcAmount(99000);

        assertThat(amount1).isEqualTo(8);
        assertThat(amount2).isEqualTo(1);
        assertThat(amount3).isEqualTo(99);
    }

    @DisplayName("랜덤 로또 생성 수량 확인")
    @Test
    void makeLottosTest() {
        List<Lotto> lottos = lottoService.makeLottos(8);
        assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("로또 번호 랜덤 생성 확인")
    @Test
    void randomTest() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i=0; i<randomNumbers.size(); i++) {
            assertThat(randomNumbers.get(i)).isGreaterThan(0).isLessThan(46);
        }
        Set<Integer> nums = new HashSet<>(randomNumbers);
        assertThat(nums.size()).isEqualTo(randomNumbers.size());
    }

    @DisplayName("로또 번호와 당첨 번호 비교 확인")
    @Test
    void compareTest() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        int[] result = lottoService.compare(lottos, winningLotto, bonusNumber);
        int bonusCount = lottoService.checkBonus(bonusNumber, winningLotto);
        assertThat(result[3]).isEqualTo(1); //3개
        assertThat(result[4]).isEqualTo(0); //4개
        assertThat(result[5]).isEqualTo(0); //5개
        assertThat(result[6]).isEqualTo(0); //5개 + 보너스
        assertThat(result[7]).isEqualTo(0); //6개
        assertThat(bonusCount).isEqualTo(0);
    }

    @DisplayName("수익률 계산")
    @Test
    void calcProfitTest() {
        int result[] = {0, 0, 0, 1, 0, 0, 0, 0};
        int cash = 8000;
        double profit = lottoService.calcProfit(result, cash);
        assertThat(profit).isEqualTo(62.5);
    }

}
