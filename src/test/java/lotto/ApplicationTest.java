package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.LottoController;
import lotto.controller.NumberValidator;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    NumberValidator numberValidator = new NumberValidator();
    LottoController lottoController = new LottoController();

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByDownSize() {
        assertThatThrownBy(() -> numberValidator.prizeNumValidate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호의 개수가 6개가 넘으면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> numberValidator.prizeNumValidate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoNotNum() {

        assertThatThrownBy(() -> numberValidator.prizeLottoNumValidator("1,2,3,4,5,s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호에 숫자가 공백이 들어오면 예외가 발생한다.")
    @Test
    void createLottoEmptyNum() {

        assertThatThrownBy(() -> numberValidator.prizeLottoNumValidator("1,2,3,4,,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호에 숫자가 중복값이 들어오면 예외가 발생한다.")
    @Test
    void createLottoAlreadyNum() {

        assertThatThrownBy(() -> numberValidator.prizeLottoNumValidator("1,2,3,4,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호와 보너스 번호 숫자가 중복값이 들어오면 예외가 발생한다.")
    @Test
    void createPrizeNumAndBonusNum() {

        assertThatThrownBy(() -> numberValidator.lottoBonusNumValidator("7",List.of(1,2,3,4,5,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자가 빈 값이 들어오면 예외가 발생한다.")
    @Test
    void createBonusEmptyNum() {

        assertThatThrownBy(() -> numberValidator.lottoBonusNumValidator("",List.of(1,2,3,4,5,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void createBonusNotNum() {

        assertThatThrownBy(() -> numberValidator.lottoBonusNumValidator("s",List.of(1,2,3,4,5,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
