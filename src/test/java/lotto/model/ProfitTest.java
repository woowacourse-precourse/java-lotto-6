package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Profit Domain 테스트")
public class ProfitTest {
    private Profit profit;

    @BeforeEach
    public void initTest() {
        profit = new Profit(INIT_COST.getConstant());
    }

    @Test
    @DisplayName("getProfit() method 테스트")
    public void getProfitTest() {
        // when
        double gameProfit = profit.getProfit();

        // then
        assertThat(gameProfit).isEqualTo(CONSTANT_ZERO.getConstant());
    }

    @Test
    @DisplayName("getLottoCount() method 테스트")
    public void getLottoCountTest() {
        // when
        int lottoCount = profit.getLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(INIT_COST.getConstant() / LOTTO_PRICE.getConstant());
    }

    @Test
    @DisplayName("addPrizeByGrade() method 테스트")
    public void addPrizeByGradeTest() {
        // when
        profit.addPrizeByGrade(VALID_GRADE.getConstant());

        // when
        assertThat(profit.getProfit()).isNotEqualTo(CONSTANT_ZERO.getConstant());
    }
}
