package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {


        @DisplayName("입력된 금액이 1000원 단위가 아니면 예외를 발생시킨다.")
        @Test
        void 구매희망_금액_입력값이_1000원_단위가_아닐_때_테스트() {
            //given
            int case1 = 100;
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


    }