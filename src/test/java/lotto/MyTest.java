package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
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
                    run("3000");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
