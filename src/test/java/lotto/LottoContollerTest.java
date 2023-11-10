package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.Util.LottoValue;
import lotto.controller.LottoController;
import lotto.controller.Setting;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LottoContollerTest {
    @DisplayName("수익률 계산")
    @Test
    void testCalculateYield() {
        double payment = 5000;
        List<Double> reward = List.of(LottoValue.NONE.getReward(),
                LottoValue.FIRST_PLACE.getReward(),
                LottoValue.SECOND_PLACE.getReward(),
                LottoValue.THIRD_PLACE.getReward(),
                LottoValue.FOURTH_PLACE.getReward(),
                LottoValue.FIFTH_PLACE.getReward());
        List<Integer> rankCount = List.of(0, 1, 1, 1, 1, 1);
        double yield = 0;
        for (int i = 1; i < rankCount.size(); i++) {
            if (rankCount.get(i) != 0) {
                yield += reward.get(i) * rankCount.get(i);
            }
        }

        double expectYield = 0;
        for (LottoValue lottoValue : LottoValue.values()) {
            expectYield += lottoValue.getReward();
        } // 4631100.0

        assertThat(yield / payment * 100).isEqualTo(expectYield);
    }


    @DisplayName("번호 일치 개수 증가 확인")
    @Test
    void testCountNumberOfMatch() {
        List<Integer> purchasedLottoNumber = List.of(1,2,3,4,5,6);
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        LottoController lottoController = new LottoController();
        double numberOfMatch = lottoController.countNumberfOfMatch(purchasedLottoNumber, winningNumber);

        assertThat(numberOfMatch).isEqualTo(6);
    }

    @DisplayName("일치하는 개수를 계산해서, 등수를 확인한다.")
    @Test
    void testCalculateRank() {
        LottoController lottoProcedure = new LottoController();
        List<Double> counts = List.of(6.0, 5.5, 5.0, 4.0, 3.0);
        for (int i = 0; i < counts.size(); i++) {
            int rank = lottoProcedure.calculateRank(counts.get(i));
            assertThat(rank).isEqualTo(i + 1);
        }
    }
}
