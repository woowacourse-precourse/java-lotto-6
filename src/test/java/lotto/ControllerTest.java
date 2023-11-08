package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.Controller;
import lotto.policy.WinConditionPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    @DisplayName("당첨 번호 5개 일치, 보너스 번호 1개 일치 때 2등 당첨 결과를 추가한다.")
    @Test
    void addSecondPlaceByMatchFiveWinNumberAndOneBonusNumber() {
        //given
        Controller controller = new Controller();
        List<WinConditionPolicy> winResult = new ArrayList<>();
        int winNumberCount = 5;
        int bonusNumberCount = 1;

        //when
        controller.makeResults(winResult, winNumberCount, bonusNumberCount);

        //then
        assertThat(winResult).contains(WinConditionPolicy.SECOND_PLACE);
    }
}
