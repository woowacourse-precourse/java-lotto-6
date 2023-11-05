package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest extends NsTest {

    @Test
    void 오류_1000의_배수입력안함() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(INPUT_MULTIPLES_OF_1000_ERROR.getMessage());
        });
    }

    @Test
    void 오류_정수입력에_문자열입력() {
        assertSimpleTest(() -> {
            runException("1200fsfs");
            assertThat(output()).contains(INPUT_STRING_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_오류_중복된_번호() {
        assertSimpleTest(() -> {
            runException("2000" , "1,2,3,4,5,5");
            assertThat(output()).contains(DUPLICATED_WINNING_NUMBER_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_오류_문자열_입력() {
        assertSimpleTest(() -> {
            runException("2000" , "1,2,3,hello,5,5");
            assertThat(output()).contains(INPUT_STRING_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_오류_로또_번호_입력_범위_벗어남() {
        assertSimpleTest(() -> {
            runException("2000" , "10,200,14,16,17,18");
            assertThat(output()).contains(WINNING_NUMBER_RANGE_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_오류_로또_번호_갯수_안맞을때() {
        assertSimpleTest(() -> {
            runException("2000" , "10,200,14,16,17");
            assertThat(output()).contains(INPUT_WINNING_NUMBER_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_성공_실패_중복되는_보너스번호() {
        assertSimpleTest(() -> {
            runException("2000" , "10,20,14,16,17,30" , "10");
            assertThat(output()).contains(DUPLICATED_WINNING_NUMBER_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_성공_실패_보너스번호_범위_초과() {
        assertSimpleTest(() -> {
            runException("2000" , "10,20,14,16,17,18" , "140");
            assertThat(output()).contains(WINNING_NUMBER_RANGE_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_성공_실패_보너스번호_문자열_입력() {
        assertSimpleTest(() -> {
            runException("2000" , "10,20,14,16,17,21" , "fwfw");
            assertThat(output()).contains(INPUT_STRING_ERROR.getMessage());
        });
    }

    @Test
    void 당첨_번호_입력_성공() {
        assertSimpleTest(() -> {
            runException("2000" , "10,20,14,16,17,21" , "45");
            assertThat(output()).doesNotContain("[ERROR]");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
