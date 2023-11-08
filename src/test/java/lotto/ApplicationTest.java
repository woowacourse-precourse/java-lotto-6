package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    @DisplayName("1000원 이하의 금액은 입력 받을 수 없다.")
    @Test
    void createAmountByUnderThousand() {
        assertThatThrownBy(() -> new Amount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 금액은 입력 받을 수 없다.")
    @Test
    void createNotThousandsAmount() {
        assertThatThrownBy(() -> new Amount("1212"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 금액은 입력 받을 수 없다.")
    @Test
    void createByNotNumber() {
        assertThatThrownBy(() -> new Amount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 금액을 입력 받는다.")
    @Test
    void createAmount(){
        Amount amount = new Amount("2000");

        assertThat(amount.getMoney()).isEqualTo(2000);
    }

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

    @DisplayName("로또 번호에 범위를 초과하는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이의 수 6개를 입력 받으면 정상 동작한다.")
    @Test
    void createLotto() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 45)));
    }

    @DisplayName("형식에 맞지 않은 당첨 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByInvalidFormat() {
        WinningLotto winningLotto = new WinningLotto();
        assertThatThrownBy(() -> winningLotto.parseWinningNumbers("12 3 4,5 2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 포함한 당첨 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> parsedWinningNumbers = winningLotto.parseWinningNumbers("1,1,2,3,4,5");

        assertThatThrownBy(() -> winningLotto.validate(parsedWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 당첨 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByInvalidRangeNumber() {
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> parsedWinningNumbers = winningLotto.parseWinningNumbers("1,2,3,4,5,50");

        assertThatThrownBy(() -> winningLotto.validate(parsedWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이의 중복되지 않은 숫자로 입력 받으면 정상 동작한다.")
    @Test
    void createWinningNumbers() {
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> parsedWinningNumbers = winningLotto.parseWinningNumbers("1,2,3,4,5,6");

        assertDoesNotThrow(() -> winningLotto.validate(parsedWinningNumbers));
    }

    @DisplayName("형식에 맞지 않은 보너스 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createBonusNumberByInvalidFormat() {
        WinningLotto winningLotto = new WinningLotto();
        assertThatThrownBy(() -> winningLotto.parseBonusNumber("1,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위에 맞지 않는 보너스 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createBonusNumberByInvalidRange() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningNumbers(new Lotto(List.of(1,2,3,4,5,6)));
        assertThatThrownBy(() -> winningLotto.validate(57))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 중복되는 보너스 번호를 입력 받으면 예외가 발생한다.")
    @Test
    void createBonusNumberWithDuplicateWinningNumbers() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningNumbers(new Lotto(List.of(1,2,3,4,5,6)));
        assertThatThrownBy(() -> winningLotto.validate(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이의 당첨번호와 중복되지 않는 번호를 입력 받으면 정상 동작한다.")
    @Test
    void createBonusNumber() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningNumbers(new Lotto(List.of(1,2,3,4,5,6)));
        assertDoesNotThrow(() -> winningLotto.validate(7));
    }

    @DisplayName("당첨번호와 일치하는 숫자의 개수를 리턴한다.")
    @Test
    void returnMatchCount() {
        Long count =Ranking.getMatchCount(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,7,8,9)));
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("당첨된 로또 개수를 리턴한다.")
    @Test
    void returnWinningCount() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,7)));

        HashMap<Ranking, Integer> result = Ranking.getWinningResult(lottos, winningNumbers, 7);
        assertThat(result.get(Ranking.FIRST)).isEqualTo(1);
        assertThat(result.get(Ranking.SECOND)).isEqualTo(1);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
