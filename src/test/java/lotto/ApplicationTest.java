package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Enum.Rank;
import lotto.domain.Lotto;
import lotto.exception.InputException;
import lotto.gameUtil.GameLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private GameLogic gameLogic = new GameLogic();
    private List<Integer> winningNumber = Arrays.asList(1, 3, 11, 18, 25, 39);
    private List<Integer> buyingNumber = Arrays.asList(1, 3, 15, 18, 25, 40);
    private int bonusNumber = 39;

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

    @DisplayName("1000원단위가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 120, 119, 1004, -12, -5000})
    void checkThousandUnit(Integer money) {
        assertThatThrownBy(() -> {
            new InputException().checkThousandUnit(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 구매금액 입력 후 당첨번호 잘못입력시 (1~45 X)
    @DisplayName("당첨번호 입력시 6개를 입력하지 않음.")
    @Test
    void 당첨번호_6개_아닌_입력() {
        String[] numbers = {"1", "2", "8", "19", "35"};
        assertThatThrownBy(() -> {
            new InputException().checkNumberCount(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호, 보너스번호 입력시 숫자가 아닌 값을 입력.")
    @ParameterizedTest
    @ValueSource(strings = {"*", "12s", "abc", "3!1"})
    void 당첨번호_보너스번호_숫자가_아닌_값_입력(String number) {
        assertThatThrownBy(() -> {
            new InputException().toInt(number);
        }).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("당첨번호 입력시 1~45가 아닌 수 입력.")
    @ParameterizedTest
    @ValueSource(ints = {0, -21, 48, 100})
    void 당첨번호_숫자가_아닌_값_입력(int number) {
        assertThatThrownBy(() -> {
            new InputException().checkNotLottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("보너스 번호 입력시 당첨번호와 중복되는 값 입력")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 11, 18, 25, 39})
    void testCheckContainsBonusNumber(int bonusNumber) {
        Lotto lotto = new Lotto(winningNumber);
        assertThatThrownBy(() -> {
            new InputException().checkContainsBonusNumber(lotto, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 금액만큼_로또생성(){
        assertThat(
                new GameLogic().lottoNumber(8000).size())
                .isEqualTo(8);
    }

    @Test
    void 구매한_로또와_당첨로또_비교후_맞는Rank에_횟수가_올라가는지(){
        Lotto winningLotto = new Lotto(winningNumber);
        Lotto buyingLotto = new Lotto(buyingNumber);
        int matchCount = gameLogic.matchCount(winningLotto, buyingLotto, bonusNumber);
        boolean isSecond = gameLogic.matchBonus(winningLotto, bonusNumber);
        gameLogic.matchLotto(matchCount, isSecond);
        assertThat(
                gameLogic.getRanks().get(Rank.THIRD)
        ).isEqualTo(1);
    }
}
