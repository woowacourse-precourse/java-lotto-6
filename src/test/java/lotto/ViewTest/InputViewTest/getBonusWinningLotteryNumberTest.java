package lotto.ViewTest.InputViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Lotto;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class getBonusWinningLotteryNumberTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("범위를 벗어난 보너스 숫자가 들어온 경우")
    @Test
    public void getOutOfRangeBonusNumber()
    {
        run("46","-1", "7");
        assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE, "7");
    }

    @DisplayName("중복된 보너스 숫자가 들어온 경우")
    @Test
    public void getOverlappedValueAsBonusNumber()
    {
        run("6", "7");
        assertThat(output()).contains(ERROR_MESSAGE, "7");
    }

    @DisplayName("숫자가 아닌 것이 입력으로 들어온 경우")
    @Test
    public void getNonIntegerAsInput()
    {
        run("aaa", "7");
        assertThat(output()).contains(ERROR_MESSAGE, "7");
    }

    @Override
    public void runMain()
    {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(new InputView().getBonusWinningLotteryNumber(lotto));
    }
}
