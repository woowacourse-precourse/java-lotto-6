package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.controller.constant.ErrorConst.INPUT_NOT_INT;
import static lotto.domain.constant.ErrorConst.BONUS_OUT_OF_RANGE;
import static lotto.domain.constant.ErrorConst.LOTTO_COUNT_NOT_SIX;
import static lotto.domain.constant.ErrorConst.LOTTO_HAS_DUPLICATE;
import static lotto.domain.constant.ErrorConst.LOTTO_OUT_OF_RANGE;
import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;
import static lotto.domain.constant.ErrorConst.WINNING_HAS_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationExceptionTest extends NsTest {

    @Test
    @DisplayName("로또 구입 금액을 잘못 입력하면 에러 메시지 출력 후 다시 입력받는다.")
    void checkAllExceptionCaseWhenInputPrice() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("asdf", "2147483648", "-2147483649", //INPUT_NOT_INT
                            "0", //PRICE_LESS_THAN_THOUSAND
                            "1234", //PRICE_NOT_DIVIDED_BY_THOUSAND
                            "1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).containsSubsequence(
                            INPUT_NOT_INT, //"asdf"
                            INPUT_NOT_INT, //"2147483648"
                            INPUT_NOT_INT, //"-2147483649"
                            PRICE_LESS_THAN_THOUSAND, //"0"
                            PRICE_NOT_DIVIDED_BY_THOUSAND //"1234"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("당첨 번호 6자리를 잘못 입력하면 에러 메시지 출력 후 다시 입력받는다.")
    void checkAllExceptionCaseWhenInputWinningMain() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000",
                            "asdf", "a,b", "1, 2", "a,b,c,d,e,f", "1,2,3,4,5,2147483648", //INPUT_NOT_INT
                            "1,2,3,4,5", "1,2,3,4,5,6,7",  //LOTTO_COUNT_NOT_SIX
                            "1,2,3,4,5,46", "1,2,3,4,0,6", //LOTTO_OUT_OF_RANGE
                            "3,4,5,6,7,4", //LOTTO_HAS_DUPLICATE
                            "1,2,3,4,5,6", "7");
                    assertThat(output()).containsSubsequence(
                            INPUT_NOT_INT, //"asdf"
                            INPUT_NOT_INT, //"a,b"
                            INPUT_NOT_INT, //"1, 2"
                            INPUT_NOT_INT, //"a,b,c,d,e,f"
                            INPUT_NOT_INT, //"1,2,3,4,5,2147483648"
                            LOTTO_COUNT_NOT_SIX, //"1,2,3,4,5"
                            LOTTO_COUNT_NOT_SIX, //"1,2,3,4,5,6,7"
                            LOTTO_OUT_OF_RANGE, //"1,2,3,4,5,46"
                            LOTTO_OUT_OF_RANGE, //"1,2,3,4,0,6"
                            LOTTO_HAS_DUPLICATE //"3,4,5,6,7,4"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("보너스 번호 1자리를 잘못 입력하면 에러 메시지 출력 후 다시 입력받는다.")
    void checkAllExceptionCaseWhenInputWinningBonus() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6",
                            "asdf", " ", "2147483648", //INPUT_NOT_INT
                            "0", "46", //BONUS_OUT_OF_RANGE
                            "2", //WINNING_HAS_DUPLICATE
                            "7");
                    assertThat(output()).containsSubsequence(
                            INPUT_NOT_INT, //"asdf"
                            INPUT_NOT_INT, //" "
                            INPUT_NOT_INT, //"2147483648"
                            BONUS_OUT_OF_RANGE, //"0"
                            BONUS_OUT_OF_RANGE, //"46"
                            WINNING_HAS_DUPLICATE //"2"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
