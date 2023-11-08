package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupTest {

    LottoNumGenerator generator = new LottoNumGenerator();
    static final Integer LOTTERY_BUDGET = 7000;

    @DisplayName("입력된 로또 번호 그룹 수 만큼의 로또가 발행되는지 테스트")
    @Test
    void 로또_갯수_발행_테스트() {
        List<List<Integer>> lotteryNumGroup = generator.generateLotteryNumbersGroup(LOTTERY_BUDGET);
        LottoGroup lottoGroup = new LottoGroup(lotteryNumGroup);
        assertThat(lottoGroup.getLottoGroup().size()).isEqualTo(lotteryNumGroup.size());
    }
}
