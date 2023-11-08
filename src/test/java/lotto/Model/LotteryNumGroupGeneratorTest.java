package lotto.Model;

import static lotto.Constants.BudgetConstants.BUDGET_UNIT;
import static lotto.Constants.LottoGameInputConstants.LOTTO_NUM_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryNumGroupGeneratorTest {
    LottoNumGenerator generator = new LottoNumGenerator();
    static final Integer LOTTERY_BUDGET = 3000;

    @Test
    @DisplayName("중복된 숫자 출력되는지 확인")
    public void 중복_출력_여부_검증() {
        List<List<Integer>> lotteryNumGroup = generator.generateLotteryNumbersGroup(LOTTERY_BUDGET);
        for (List<Integer> lotteryNum : lotteryNumGroup) {
            Set<Integer> uniqueSet = new HashSet<>(lotteryNum);
            assertThat(uniqueSet.size()).isEqualTo(LOTTO_NUM_AMOUNT.getNum());
            assertThat(lotteryNum.size()).isEqualTo(LOTTO_NUM_AMOUNT.getNum());
        }
    }

    @Test
    @DisplayName("입력된 금액에 맞는 로또 숫자 리스트가 발생되는지 확인")
    public void 금액에_맞는_갯수_출력_여부_검증() {
        List<List<Integer>> lotteryNumGroup = generator.generateLotteryNumbersGroup(LOTTERY_BUDGET);
        Integer expected = LOTTERY_BUDGET / BUDGET_UNIT.getPrice();
        assertThat(lotteryNumGroup).hasSize(expected);
    }
}
