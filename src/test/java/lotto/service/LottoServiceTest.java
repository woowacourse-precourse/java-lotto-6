package lotto.service;

import lotto.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("금액에 따라 로또 번호 생성 - 성공")
    public void generateLottoNumbers() throws Exception {
        //given
        String inputPurchaseMoney = "4000";
        lottoService.getLottoCount(inputPurchaseMoney);
        //when
        List<List<Integer>> purchaseLottoNumbers = lottoService.purchaseLottoNumberProcess();
        //then
        assertThat(purchaseLottoNumbers.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("수익률 계산 - 성공")
    public void getRevenueRate() throws Exception {
        //given
        String inputPurchaseMoney = "4000"; // 걸은 돈: 4000원
        lottoService.getLottoCount(inputPurchaseMoney);
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        result.put(Ranking.FIFTH, 1); // 상금: 5000원
        //when
        double revenueRate = lottoService.getRevenueRate(result);

        //then
        assertThat(revenueRate).isEqualTo(125.0);
    }


}
