package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호가 1 ~ 45에 포함되어 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoNumberByIncorrectRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 50, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행된 로또 번호를 오름차순 정렬한다.")
    @Test
    void createLottoByNotSortedNumber() {
        List<Integer> numbers = new Lotto(List.of(6, 1, 2, 3, 4, 5)).getNumbers();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("맞힌 로또 번호를 모아서 반환한다.")
    @Test
    void getMatchedLotto() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "3개 일치 (5,000원) - 1개",
                    "4개 일치 (50,000원) - 1개",
                    "5개 일치 (1,500,000원) - 1개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                    "6개 일치 (2,000,000,000원) - 1개"
                );
            },
            List.of(1,2,3,43,44,45),
            List.of(1,2,3,4,44,45),
            List.of(1,2,3,4,5,45),
            List.of(1,2,3,4,5,7),
            List.of(1,2,3,4,5,6)
        );
    }

    @DisplayName("수익률 계산이 알맞는지 확인한다.")
    @Test
    void calculateEarningRate() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "총 수익률은 40631100.0%입니다."
                );
            },
            List.of(1,2,3,43,44,45),
            List.of(1,2,3,4,44,45),
            List.of(1,2,3,4,5,45),
            List.of(1,2,3,4,5,7),
            List.of(1,2,3,4,5,6)
        );
    }

    @DisplayName("수익률이 소수점 둘째 자리에서 반올림되는지 확인한다.")
    @Test
    void displayEarningRateWithRoundOff() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                run("5000", "1,2,3,4,5,6", "7");
                assertThat(output()).contains(
                    "40631100.0%"
                );
            },
            List.of(1,2,3,43,44,45),
            List.of(1,2,3,4,44,45),
            List.of(1,2,3,4,5,45),
            List.of(1,2,3,4,5,7),
            List.of(1,2,3,4,5,6)
        );
    }

    @DisplayName("구매 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByIncorrectUnit() {
        assertSimpleTest(() -> {
            runException("1111");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("예외 발생 시 '[ERROR]'로 시작하는 메시지를 출력한다.")
    @Test
    void displayExceptionMessage() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 50, 4, 5)))
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}