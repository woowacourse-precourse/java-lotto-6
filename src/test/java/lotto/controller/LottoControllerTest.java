package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import lotto.configuration.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    @Test
    @DisplayName("[정상 테스트]")
    void ControllerTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 5, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1,100,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 9)
        );
    }


    @Test
    @DisplayName("[입력 오류 테스트] 구매 금액")
    void controllerWrongInputMoney() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8100", "*", "100", "3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            ErrorMessage.INPUT_NOT_NUMBER,
                            ErrorMessage.UNIT_NOT_VALID,
                            ErrorMessage.NOT_ENOUGH_MONEY,
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 5, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1,100,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 9)
        );
    }

    @Test
    @DisplayName("[입력 오류 테스트] 당첨 번호 개수")
    void controllerWrongWinningNumberLength() {
        List<String> wrongWinningNumbers = List.of("1,2,3,4,5", "1,2,3,4,5,6,7");

        for (String winningNumbers : wrongWinningNumbers) {
            init();
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("3000", winningNumbers, "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                                ErrorMessage.WRONG_LOTTO_NUMBER_LENGTH,
                                "3개를 구매했습니다.",
                                "[1, 2, 3, 4, 5, 7]",
                                "[1, 2, 3, 4, 5, 8]",
                                "[1, 2, 3, 4, 5, 9]",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 2개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 1,100,000.0%입니다."
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(1, 2, 3, 4, 5, 8),
                    List.of(1, 2, 3, 4, 5, 9)
            );
            printOutput();
        }
    }

    @Test
    @DisplayName("[입력 오류 테스트] 당첨 번호 숫자 범위")
    void controllerWrongWinningNumberRange() {
        List<String> wrongWinningNumbers = List.of("0,1,2,3,4,5", "1,2,3,4,5,46");

        for (String winningNumbers : wrongWinningNumbers) {
            init();
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("3000", winningNumbers, "1,2,3,4,5,6", "7");
                        assertThat(output()).contains(
                                ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE,
                                "3개를 구매했습니다.",
                                "[1, 2, 3, 4, 5, 7]",
                                "[1, 2, 3, 4, 5, 8]",
                                "[1, 2, 3, 4, 5, 9]",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 2개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 1,100,000.0%입니다."
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(1, 2, 3, 4, 5, 8),
                    List.of(1, 2, 3, 4, 5, 9)
            );
            printOutput();
        }
    }

    @Test
    @DisplayName("[입력 오류 테스트] 당첨 번호 중복됨")
    void controllerWrongWinningNumberDuplicated() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,5", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            ErrorMessage.NUMBER_DUPLICATED,
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 5, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1,100,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 9)
        );
    }

    @Test
    @DisplayName("[입력 오류 테스트] 보너스 번호 숫자 아니거나 중복됨")
    void controllerWrongBonusNumberNotIntORDuplicated() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "*", "6", "7");
                    assertThat(output()).contains(
                            ErrorMessage.INPUT_NOT_NUMBER,
                            ErrorMessage.BONUS_NUMBER_DUPLICATED,
                            "3개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "[1, 2, 3, 4, 5, 8]",
                            "[1, 2, 3, 4, 5, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 1,100,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 9)
        );
    }

    @Test
    @DisplayName("[입력 오류 테스트] 보너스 번호 범위 잘못됨")
    void controllerWrongBonusNumberRange() {
        List<String> wrongBonusNumbers = List.of("0", "46");

        for (String wrongBonusNumber : wrongBonusNumbers) {
            init();
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        run("3000", "1,2,3,4,5,6", wrongBonusNumber, "7");
                        assertThat(output()).contains(
                                ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE,
                                "3개를 구매했습니다.",
                                "[1, 2, 3, 4, 5, 7]",
                                "[1, 2, 3, 4, 5, 8]",
                                "[1, 2, 3, 4, 5, 9]",
                                "3개 일치 (5,000원) - 0개",
                                "4개 일치 (50,000원) - 0개",
                                "5개 일치 (1,500,000원) - 2개",
                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                "6개 일치 (2,000,000,000원) - 0개",
                                "총 수익률은 1,100,000.0%입니다."
                        );
                    },
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(1, 2, 3, 4, 5, 8),
                    List.of(1, 2, 3, 4, 5, 9)
            );
            printOutput();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}