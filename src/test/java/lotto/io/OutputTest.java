package lotto.io;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;



class OutputTest extends NsTest{

    @Test
    void printResult() {
        assertSimpleTest(() -> {
            Output.printResult(List.of(0, 0, 0, 0, 1, 7));
            assertThat(output()).contains("총 수익률은 62.5%입니다");
        });
    }
    @Override
    protected void runMain() {

    }
}