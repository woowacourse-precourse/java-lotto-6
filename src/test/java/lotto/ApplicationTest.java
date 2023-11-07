package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Model.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    public void beforeEach(){
        // enum 카운트 개수 초기화
        Prize.SIX.setCount(0);
        Prize.FIVE_BONUS.setCount(0);
        Prize.FIVE.setCount(0);
        Prize.FOUR.setCount(0);
        Prize.THREE.setCount(0);
    }
    @Test
    void 보너스번호_범위_체크(){
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,6" , "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }
    @Test
    void 보너스번호_공백문자_체크(){
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,6" , " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }
    @Test
    void 보너스번호_숫자_체크(){
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,6" , "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }
    @Test
    void 보너스번호_중복_체크(){
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,6" , "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Test
    void 당첨번호_범위_테스트(){
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Test
    void 당첨번호_중복숫자_테스트() {
        assertSimpleTest(() -> {
            runException("1000" , "1,1,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 당첨번호_6개숫자_테스트() {
        assertSimpleTest(() -> {
            runException("1000" , "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    void 당첨번호_공백문자_테스트() {
        assertSimpleTest(() -> {
            runException("1000" , "1,,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 당첨번호_숫자_테스트() {
        assertSimpleTest(() -> {
            runException("1000" , "a,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    void 구입금액_0_불가_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_숫자_테스트() {
        assertSimpleTest(() -> {
            runException("asdf");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입금액_천원단위_테스트() {
        assertSimpleTest(() -> {
            runException("500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
