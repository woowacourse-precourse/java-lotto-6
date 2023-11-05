package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.model.Lottos;

class OutputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @DisplayName("발행한 로또 수량 및 번호를 출력한다.")
    @Test
    void printLottos() {
        // given
        Lottos lottos = Lottos.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );

        String expect = """
                3개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 7]
                [1, 2, 3, 4, 5, 8]""";

        // when
        outputView.printPurchaseResult(lottos);

        // then
        assertThat(output()).contains(expect);
    }

    @Override
    protected void runMain() {
    }
}
