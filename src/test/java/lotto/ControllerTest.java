package lotto;

import lotto.controller.LottoController;
import lotto.model.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    LottoController lottoController = new LottoController();

    @Test
    @DisplayName("지불금액만큼 생성되는지 확인")
    void provide_payment() {
        lottoController.generateLotto(5000);
        assertThat(lottoController.getLotteries().size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("랭킹 열거형 리스트를 제대로 반환하는지 테스트")
    void checkTotalRanking() {
        lottoController.generateLotto(10000);
        assertThat(lottoController.getTotalRanking(List.of(1,2,3,4,5,6), 10).stream())
                .containsAnyOf(Ranking.values());
    }
}
