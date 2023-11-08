package lotto.view.inputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.utils.Validation;
import lotto.utils.ValidationImpl;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InsertWinningNumbersTest extends NsTest {
    @DisplayName("당첨 번호 6개")
    @Test
    void test1() {
        Assertions.assertSimpleTest(() -> {
            run("1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,6");
            assertThat(output()).contains("당첨 번호 6개를 입력해주세요.");
        });
    }

    @DisplayName("오직 숫자와 쉼표만 가능")
    @Test
    void test2() {
        Assertions.assertSimpleTest(() -> {
            run("1,2,(*,4,5,***", "1,2,3,4,5,6");
            assertThat(output()).contains("오직 숫자와 쉼표만 입력 가능합니다.");
        });
    }

    @DisplayName("쉼표 사이에 숫자 입력")
    @Test
    void test3() {
        Assertions.assertSimpleTest(() -> {
            run("1,2,,4,5,6", "1,2,3,4,5,6");
            assertThat(output()).contains("쉼표 사이에 숫자를 입력해주세요.");
        });
    }

    @DisplayName("중복된 숫자")
    @Test
    void test4() {
        Assertions.assertSimpleTest(() -> {
            run("1,2,14,14,5,6", "1,2,3,4,5,6");
            assertThat(output()).contains("중복된 숫자가 있습니다.");
        });
    }

    @Override
    protected void runMain() {
        Validation validation = new ValidationImpl();
        InputView inputView = new InputViewImpl(validation);
        inputView.insertWinningNumbers();
    }
}
