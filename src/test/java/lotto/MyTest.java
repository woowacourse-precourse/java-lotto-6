package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyTest extends NsTest {
    private LottoController lottoController;
    private LottoDB lottoDB;

    @DisplayName("로또를 구입할 금액이 정수형으로 올바르게 입력되지 않으면 에러가 발생한다.")
    @Test
    public void checkLottoCountInputError1() {
        assertThatThrownBy(() -> {
            lottoController = new LottoController();
            lottoController.convertStringToInteger("abcd");
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또를 구입할 금액이 1000으로 나누어 떨어지지 않으면 에러가 발생한다.")
    @Test
    public void checkLottoCountInputError2() {
        assertThatThrownBy(() -> {
            lottoController = new LottoController();
            lottoController.checkUserInputIsThousandUnit(1234);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @Test
    void setLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("15000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "15개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[7, 2, 3, 4, 5, 6]",
                            "[7, 2, 3, 4, 5, 6]",
                            "[11, 2, 3, 4, 5, 6]",
                            "[11, 2, 3, 4, 5, 6]",
                            "[11, 2, 3, 4, 5, 6]",
                            "[11, 22, 3, 4, 5, 6]",
                            "[11, 22, 3, 4, 5, 6]",
                            "[11, 22, 3, 4, 5, 6]",
                            "[11, 22, 3, 4, 5, 6]",
                            "[11, 22, 33, 4, 5, 6]",
                            "[11, 22, 33, 4, 5, 6]",
                            "[11, 22, 33, 4, 5, 6]",
                            "[11, 22, 33, 4, 5, 6]",
                            "[11, 22, 33, 4, 5, 6]",
                            "3개 일치 (5,000원) - 5개",
                            "4개 일치 (50,000원) - 4개",
                            "5개 일치 (1,500,000원) - 3개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 13764833.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 2, 3, 4, 5, 6),
                List.of(7, 2, 3, 4, 5, 6),
                List.of(11, 2, 3, 4, 5, 6),
                List.of(11, 2, 3, 4, 5, 6),
                List.of(11, 2, 3, 4, 5, 6),
                List.of(11, 22, 3, 4, 5, 6),
                List.of(11, 22, 3, 4, 5, 6),
                List.of(11, 22, 3, 4, 5, 6),
                List.of(11, 22, 3, 4, 5, 6),
                List.of(11, 22, 33, 4, 5, 6),
                List.of(11, 22, 33, 4, 5, 6),
                List.of(11, 22, 33, 4, 5, 6),
                List.of(11, 22, 33, 4, 5, 6),
                List.of(11, 22, 33, 4, 5, 6)
        );
    }

    @DisplayName("로또의 당첨 번호가 6개가 아니면 에러가 발생한다.")
    @Test
    public void checkLottoWinningNumberError1() {
        assertThatThrownBy(() -> {
            ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            lottoController = new LottoController();
            lottoController.setLotto(numbers);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또의 당첨 번호 모두가 1보다 커야한다.")
    @Test
    public void checkLottoWinningNumberError2() {
        assertThatThrownBy(() -> {
            String[] input = {"0", "1", "2", "3", "4", "5"};
            lottoController = new LottoController();
            lottoController.convertStringListToIntegerList(input);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또의 당첨 번호 모두가 45보다 작아야한다.")
    @Test
    public void checkLottoWinningNumberError3() {
        assertThatThrownBy(() -> {
            String[] input = {"1", "2", "3", "4", "5", "46"};
            lottoController = new LottoController();
            lottoController.convertStringListToIntegerList(input);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또의 당첨 번호가 정수로 구성되어야한다.")
    @Test
    public void checkLottoWinningNumberError4() {
        assertThatThrownBy(() -> {
            String[] input = {"a", "2", "3", "4", "5", "!"};
            lottoController = new LottoController();
            lottoController.convertStringListToIntegerList(input);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또의 당첨 번호가 서로 중복되지 않은 값이여야한다.")
    @Test
    public void checkLottoWinningNumberError5() {
        assertThatThrownBy(() -> {
            String[] input = {"1", "1", "3", "4", "5", "6"};
            lottoController = new LottoController();
            lottoController.convertStringListToIntegerList(input);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    @DisplayName("로또의 보너스 번호가 서로 중복되지 않은 값이여야한다.")
    @Test
    public void checkLottoBonusNumberError1() {
        assertThatThrownBy(() -> {
            List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(input);
            lotto.checkDuplicateForBonusNumber(1);
        })
                .isInstanceOf(IllegalArgumentException.class); // 예외 유형을 확인
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
