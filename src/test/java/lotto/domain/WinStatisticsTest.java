package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinStatisticsTest {

    @Test
    void 결과_출력_테스트_5등() {
        String result = WinStatistics.getStatisticsString(List.of(3, 0, 0, 0, 0, 0, 0, 0), 5000);
        assertThat(result).contains("62.5%");
    }

    @Test
    void 결과_출력_테스트_2등() {
        String result = WinStatistics.getStatisticsString(List.of(7, 0, 0, 0, 0, 0, 0, 0), 30000000);
        assertThat(result).contains("30,000,000");
    }

    @Test
    void 결과_출력_테스트_1등() {
        String result = WinStatistics.getStatisticsString(List.of(7, 0, 0, 0, 0, 0, 0, 0), 200000000);
        assertThat(result).contains("2,000,000,000");
    }
}
