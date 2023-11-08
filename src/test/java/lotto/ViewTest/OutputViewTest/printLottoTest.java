package lotto.ViewTest.OutputViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Lotto;
import lotto.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class printLottoTest extends NsTest {
    @DisplayName("PrintLotto의 형식이 바른지 확인하는 테스트")
    @Test
    public void testPrintLotto()
    {
        run();
        assertThat(output()).contains("[1, 2, 3, 4, 5, 6]", "[2, 3, 4, 5, 6, 7]");
    }

    public void runMain()
    {
        List<Lotto> lottos = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7))));
        new OutputView().printLotto(lottos);
    }
}
