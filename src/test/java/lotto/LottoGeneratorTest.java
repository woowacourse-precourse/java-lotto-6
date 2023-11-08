package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("지불한 금액 만큼 로또 생성하는지 확인")
    @Test
    void generateCorrectAmountLottery() {
        int amount = 5;
        List<Lotto> lotteries = LottoGenerator.generateLotteries(amount);
        Assertions.assertThat(lotteries.size()).isEqualTo(amount);
    }
}
