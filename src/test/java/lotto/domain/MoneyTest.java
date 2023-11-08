package lotto.domain;

import java.util.NoSuchElementException;
import lotto.constants.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {


    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    @DisplayName("로또 금액 입력 유효성 검증 테스트")
    public void testValidInputMoney(int money) {
        Money inputMoney = new Money(money);
        assertEquals(money, inputMoney.getMoney());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 1500, 2500, 3500})
    @DisplayName("유효하지 않은 로또 금액 입력 예외 테스트, 재입력으로 인해 예외가 발생한다.")
    public void testInvalidInputMoney(int money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    @DisplayName("로또 수익 계산 테스트")
    public void testCalculateTotalWinnings(int totalPurchaseAmount) {
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH
        );

        Money money = new Money(totalPurchaseAmount);
        int totalWinnings = money.calculateTotalWinnings(lottoRanks);
        int expectedTotalWinnings = lottoRanks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();

        assertEquals(expectedTotalWinnings, totalWinnings);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    @DisplayName("수익률 계산 테스트")
    public void testCalculateReturnOfRate(int totalPurchaseAmount) {
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH
        );

        Money money = new Money(totalPurchaseAmount);
        int totalWinnings = money.calculateTotalWinnings(lottoRanks);
        double returnOfRate = money.calculateReturnOfRate(totalPurchaseAmount, totalWinnings);

        double expectedReturnOfRate =
                totalPurchaseAmount == 0 ? 0 : ((double) totalWinnings / totalPurchaseAmount) * 100;
        assertEquals(expectedReturnOfRate, returnOfRate, 0.001);
    }
}
