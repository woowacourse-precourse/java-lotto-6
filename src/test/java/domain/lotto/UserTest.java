package domain.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.catchThrowable;

import domain.Rank;
import domain.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserTest {

    @Test
    void 천원_단위로_입력이_되지_않으면_예외가_발생한다() {
        //given
        int amount1 = 1234;
        int amount2 = 12340;

        //when
        Throwable result1 = catchThrowable(() -> {
            new User(amount1);
        });
        Throwable result2 = catchThrowable(() -> {
            new User(amount2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_1000원_미만_10만원_초과일_때_예외가_발생한다() {
        //given
        int amount1 = 0;
        int amount2 = 100_001;

        //when
        Throwable result1 = catchThrowable(() -> {
            new User(amount1);
        });
        Throwable result2 = catchThrowable(() -> {
            new User(amount2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률을_테스트한다() {
        //given
        User user = new User(24000);
        user.getLottoResult().put(Rank.FOURTH, 1);
        user.getLottoResult().put(Rank.FIFTH, 1);

        //when
        double lotteryReturns = user.getLotteryReturns();

        //then
        assertThat(lotteryReturns).isEqualTo(229.2);
    }
}
