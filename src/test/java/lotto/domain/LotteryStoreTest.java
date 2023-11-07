package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.InputMismatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryStoreTest {
    @DisplayName("금액이 1000원 단위가 아닐 경우 예외를 발생시킨다.")
    @Test
    void 투입금의_액수가_1000_단위가_아닌_경우() {
        LotteryStore lotteryStorees = new LotteryStore();
        assertThatThrownBy(() -> lotteryStorees.checkCash(1500)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호를 6개 이상 넣을 경우 예외를 발생시킨다.")
    @Test
    void 당첨_번호가_6자리가_아닐_경우() {
        LotteryStore lotteryStorees = new LotteryStore();
        assertThatThrownBy(() -> lotteryStorees.checkNumberSize(7)).isInstanceOf(InputMismatchException.class);
    }

    @DisplayName("당첨 번호에 문자가 들어있을 경우 예외를 발생시킨다.")
    @Test
    void 당첨_번호에_문자가_들어있을_경우() {
        LotteryStore lotteryStorees = new LotteryStore();
        assertThatThrownBy(() -> lotteryStorees.checkNumbers("1,2,3,4,5,ㄴㅇㄹ")).isInstanceOf(
                InputMismatchException.class);

    }
}