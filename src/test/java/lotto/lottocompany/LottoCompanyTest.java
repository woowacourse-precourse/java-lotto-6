package lotto.lottocompany;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {

    private LottoCompany lottoCompany = new LottoCompany();

    @AfterEach
    void tearDown() {
        lottoCompany = new LottoCompany();
    }

    @DisplayName("N개의 로또를 발행한다.")
    @Test
    void publishNLotto() {
        //given
        int publishCount = 5;

        //when
        lottoCompany.publishNLotto(5);
    
        //then
        assertThat(lottoCompany.getLottoBundle().getBundle().size()).isEqualTo(publishCount);
    }

    @DisplayName("전체 로또의 당첨 내역을 계산한다.")
    @Test
    void calculateReward() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;
        int publishCount = 3;
        lottoCompany.publishNLotto(publishCount);

        //when
        lottoCompany.calculateReward(winningNumbers, bonusNumber);

        //then
        assertThat(lottoCompany.getRewardHistory().getHistory().size()).isEqualTo(publishCount);
    }

}
