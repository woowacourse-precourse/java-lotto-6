package account;

import lotto.Prize;
import lotto.IncomeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class UserAccountTest {
    @ParameterizedTest
    @ValueSource(ints = {1001, 10002, 100003})
    @DisplayName("유저의 입력값은 1000으로 나뉘어야 한다.")
    void accountValidate_should_be_divided_by_1000(int invalidAccount) {
        assertThatThrownBy(() -> new UserAccount(invalidAccount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000, 2000, 20000, 3000, 30000})
    void lottoGame_trial_count(int inputMoney) {
        UserAccount userAccount = new UserAccount(inputMoney);
        assertThat(userAccount.getTrialCount()).isEqualTo(inputMoney / 1000);
    }

    @Test
    @DisplayName("투자수익률 (ROE) 계산")
    void getEarningRate() {
        //given
        int inputMoney = 100000;
        UserAccount userAccount = new UserAccount(inputMoney);
        //when
        IncomeCalculator.addCount(Prize.FIFTH);
        long totalWinning = IncomeCalculator.getTotalIncome();
        //then
        double earningRate = userAccount.getEarningRate(totalWinning);
        double expected = (double) Prize.FIFTH.getWinning() / inputMoney;
        System.out.println(earningRate);
        assertThat(earningRate).isEqualTo(100 * expected);
    }
}