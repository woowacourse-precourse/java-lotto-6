package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import View.OutputView;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @DisplayName("통계 표시 테스트")
    @Test
    public void printStatisticsTest() {
        OutputView outputView = new OutputView();
        List<Integer> tmp = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5));

        assertThatThrownBy(() -> outputView.printStatistics(tmp))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
