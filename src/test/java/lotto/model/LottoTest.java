package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest extends NsTest {
    // 로또 번호 개수 관련 테스트
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBERS_COUNT_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개이면 로또가 생성된다.")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();
    }

    // 로또 번호 범위 관련 테스트
    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자이면 로또가 생성된다.")
    @Test
    void createLottoByInRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();

        lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Assertions.assertThat(lotto).isNotNull();
    }

    // 로또 번호 중복 관련 테스트
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());

        assertThatThrownBy(() -> new Lotto(List.of(45, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 없으면 로또가 생성된다.")
    @Test
    void createLottoByNotDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto).isNotNull();

        lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Assertions.assertThat(lotto).isNotNull();
    }

    // 로또 등수 반환
    @DisplayName("3개 미만 일치 시 등수는 MISS")
    @Test
    void getRankByMiss() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(45, 44, 43, 42, 41, 40)
        );
    }

    @DisplayName("3개 일치 시 등수 테스트")
    @Test
    void getRankByFifth() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 45, 44, 43)
        );
    }

    @DisplayName("4개 일치 시 등수 테스트")
    @Test
    void getRankByFourth() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 45, 44)
        );
    }

    @DisplayName("5개 일치 시 등수 테스트")
    @Test
    void getRankByThird() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 45)
        );
    }

    @DisplayName("5개 일치, 보너스 볼 일치 시 등수 테스트")
    @Test
    void getRankBySecond() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @DisplayName("6개 일치 시 등수 테스트")
    @Test
    void getRankByFirst() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
