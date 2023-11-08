package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinStatisticsTest {

    @Test
    void 결과_출력_테스트() {
        String result = WinStatistics.getStatisticsString(List.of(3,0,0,0,0,0,0,0), 5000);
        assertThat(result).contains("62.5%");
    }
}
