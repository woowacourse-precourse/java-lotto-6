package View;

import Model.LottoProcess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Model.LottoProcess.getPoint;
import static View.ShowPoint.showPointsInRow;
import static org.junit.jupiter.api.Assertions.*;

class ShowPointTest {
    @DisplayName("11000일떄 55000개 출력")
    @Test
    void check11000Test() {
        ShowPoint.totalMoney = 0;
        double actualValue = showPointsInRow(List.of(1, 1, 0, 0, 0));
        double expected = 55000;
        assertEquals(expected, actualValue);
    }

    @DisplayName("11300일떄 4555000개 출력")
    @Test
    void check11300Test() {
        ShowPoint.totalMoney = 0;
        double actualValue = showPointsInRow(List.of(1, 1, 3, 0, 0));
        double expected = 4555000D;
        assertEquals(expected, actualValue);
    }
    @DisplayName("01327일떄 4555000개 출력")
    @Test
    void check01321Test() {
        ShowPoint.totalMoney = 0;
        double actualValue = showPointsInRow(List.of(0, 1, 3, 2, 1));
        double expected = 2064550000;
        assertEquals(expected, actualValue);
    }
}