package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest{
    OutputView view = new OutputView();
    @Test
    void 에러_메세지_출력_테스트() {
        view.printErrorMessage("test");
        assertThat(output()).isEqualTo("[ERROR] test");
    }

    @Test
    void 발행한_로또_출력_테스트() {
        List<String> numbers = List.of(
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]");
        view.printGeneratedLotto(numbers);
        assertThat(output()).contains(
                "4개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]");
    }

    @Test
    void 수익률_출력_테스트() {
        view.printProfitRate(15.63f);
        assertThat(output()).isEqualTo("총 수익률은 15.6%입니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
