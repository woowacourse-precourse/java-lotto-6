package controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("입력값이 숫자가 아니라면 예외가 발생한다.")
    void is_Input_All_Digits(){
        assertSimpleTest(() -> {
            runException("10H0j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("입력값이 1000으로 나눴을 때 0이 아니면 예외가 발생한다.")
    void is_Input_Remainder_Zero(){
        assertSimpleTest(() -> {
            runException("12300");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("추가 테스트 : 에러가 발생하면 정상적인 입력이 들어올 때까지 입력을 다시 받는다.")
    void input_until_no_error_occurs(){
        run("APPLE","12323","2000");
        assertThat(output()).contains(ERROR_MESSAGE, "2");
    }

    @Test
    @DisplayName("구입 금액을 입력받아 1000으로 나눈 결과를 lottoQuantity에 저장한다.")
    void initialize_LottoGame(){
        run("8000");
        assertThat(output()).contains("8");
    }

    @Test
    @DisplayName("구입 가능횟수가 0이면 예외가 발생한다.")
    void zero_lottoQuantity(){
        assertSimpleTest(()->{
            runException("00");
            assertThat(output()).contains("[Error] 구입 금액이 0이면 로또번호를 생성할 수 없습니다.");
        });
    }

    @Test
    @DisplayName("정수형 리스트을 입력으로 받아 당첨번호를 저장한다.")
    void setting_win_numbers(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6");
                    assertThat(output()).contains(
                            "1,2,3,4,5,6"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Test
    @DisplayName("중복되지 않는 정수를 입력으로 받아 보너스 번호를 저장한다.")
    void setting_bonus_numbers(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "6", "9");
                    assertThat(output()).contains("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없어요.");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38)
        );
    }

    @Test
    @DisplayName("모든 당첨된 로또에 대해 당첨금을 합산한다.")
    void sum_all_lotto_prizes(){
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
                            "6개 일치 (2,000,000,000원) - 0개",
                            "5000"
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
    @DisplayName("당첨금 전부 더해서 초기 투자금으로 나눈다.")
    void divide_sum_prize_with_initial_cost(){
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
                            "6개 일치 (2,000,000,000원) - 0개"
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
