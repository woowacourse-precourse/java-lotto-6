package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class BuyerTest {

    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    @Test
    void 입력금액_1000원_단위가_아닐_때_테스트() {
        //given
        int case1 = 100;
        int case2 = 1300;

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new Buyer(case2);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 1000원 보다 작을 때 예외를 발생시킨다.")
    @Test
    void 입력금액이_1000원보다_작을_때_테스트() {
        //given
        int case1 = 100;

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }
}
