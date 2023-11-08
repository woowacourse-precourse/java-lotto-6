package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 희망금액 입력값이 null이면 예외가 발생한다.")
    @Test
    void 구매_희망값_null값_테스트() {
        //given
        String case1 = "";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 희망금액 입력값에 공백이 존재하면 예외가 발생한다.")
    @Test
    void 구매_희망값_공백값_테스트() {
        //given
        String case1 = "499 0";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 희망금액 입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구매_희망값_숫자_테스트() {
        //given
        String case1 = "5ㄱ5";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 희망금액 입력값이 천원단위가 아니면 예외가 발생한다.")
    @Test
    void 구매_희망값_천원단위_테스트() {
        //given
        String case1 = "5000";

        //when
        Throwable result1 = catchThrowable(() -> {
            new Buyer(case1);
        });

        //then
        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

}