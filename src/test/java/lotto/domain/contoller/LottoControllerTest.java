package lotto.domain.contoller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
    }

    @Test
    void 구매_금액_테스트() {
        assertSimpleTest(() -> {
            runException("8000");
            assertThat(output()).contains("8개");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}