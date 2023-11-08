package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {
	
	@DisplayName("입력된 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validateDivisible() {
        int case1 = 100;
        int case2 = 1300;

        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new Buyer(case2);
        });

        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("입력된 금액이 10만원 이상이면 예외가 발생한다.")
    @Test
    void TooMuchAmount() {
        int case1 = 1000000;

        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }
	
	 @DisplayName("구매자의 로또 수익률을 계산하는 기능")
	 @Test
	 void calculateProfit() {
	     Buyer buyer = new Buyer(12000);
	     buyer.getLottoResult().put(Rank.FOURTH,1);

	     double result = buyer.getYield();

	     assertThat(result).isEqualTo(416.7);
	 }
	
}
