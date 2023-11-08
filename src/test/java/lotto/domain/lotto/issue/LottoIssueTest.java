package lotto.domain.lotto.issue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoPrice;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.lotto.lottery.RandomLotteryMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 발행 도메인")
public class LottoIssueTest {
    @Test
    @DisplayName("로또 구입 금액에 가격을 나눈 만큼 여러 개의 로또를 발행합니다.")
    void Should_Issue_LottoGroup_When_Amount_And_Price_Are_Prepared() {
        //given
        final int numberOfPurchases = 5;
        final int amount = LottoPrice.ONE.getPrice() * numberOfPurchases;
        final LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);

        //when
        final LottoIssue lottoIssue = new LottoIssue(new RandomLotteryMachine());
        final LottoGroup actual = lottoIssue.issue(lottoPurchaseAmount, LottoPrice.ONE);

        //then
        assertThat(actual).isEqualTo(actual);
    }
}
