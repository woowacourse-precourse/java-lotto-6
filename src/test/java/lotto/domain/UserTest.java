package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {


        @DisplayName("입력된 금액이 1000원 단위가 아니면 예외를 발생")
        @Test
        void isValidUserAmountTest() {
            //given
            int case1 = 30;
            int case2 = 1300;

            //when
            Throwable result1 = catchThrowable(() -> {
                new User(case1);
            });
            Throwable result2 = catchThrowable(() -> {
                new User(case2);
            });

            //then
            assertThat(result1).isInstanceOf(IllegalArgumentException.class);
            assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        }


    @DisplayName("구매자의 로또 수익률을 계산")
    @Test
    void rateOfReturnTest() {
        //given
        User user = new User(76000);
        user.getLottoResult().put(Rank.FOURTH,1);
        user.getLottoResult().put(Rank.FIFTH,1);

        //when
        double result = user.getRateOfReturn(user);

        //then
        assertThat(result).isEqualTo(72.4);
    }


}