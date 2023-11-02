package lotto;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
