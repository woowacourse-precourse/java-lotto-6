package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void 입력금액_정수변환(){
        String test = "123";
        Assertions.assertEquals(123, money_for_lotto.realMoney(test));
    }

    @Test
    void 숫자가_아닌_초기입력예외(){
        String test = "숫자가 아님";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsNumber(test));
    }

    @Test
    void 공백_초기입력예외(){
        String test = " ";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsNumber(test));
    }

    @Test
    void 음수_초기입력예외(){
        int test1 = 0;
        int test2 = -100;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {money_for_lotto.moneyIsOver0(test1);});
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {money_for_lotto.moneyIsOver0(test2);});
    }

    @Test
    void 천의_배수_입력확인(){
        int test = 123;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {money_for_lotto.multipleOfThousand(test);});
    }

    @Test
    void 복권_개수_계산_테스트(){
        int test = 14000;
        Assertions.assertEquals(14, money_for_lotto.repeatTime(test));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
