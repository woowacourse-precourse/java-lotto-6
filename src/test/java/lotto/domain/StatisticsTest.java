package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static lotto.domain.Statistics.*;
import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @DisplayName("일치개수, 보너스번호, 발행로또 번호를 입력받아 알맞은 enum을 반환한다.")
    @Test
    void returnStatisticsTest() {
        Statistics statistics = getStatistics(3, 22, Arrays.asList(1, 2, 3, 4, 22, 33));

        Assertions.assertThat(statistics).isEqualTo(THREE);
    }

    @DisplayName("일치개수, 보너스번호, 발행로또 번호를 입력받아 보너스 enum을 반환한다.")
    @Test
    void returnBonusStatisticsTest() {
        Statistics statistics = getStatistics(4, 22, Arrays.asList(1, 2, 3, 4, 22, 33));

        Assertions.assertThat(statistics).isEqualTo(FIVE_BONUS);
    }

    @DisplayName("당첨 통계 상세 내역을 반환한다.")
    @Test
    void returnOutputStatistics() {
        StringBuilder sb = new StringBuilder();
        Map<Statistics, Integer> testMap = new HashMap<>(){{
            put(SIX, 3);
        }};
        makeOutputStatistics(SIX, sb, testMap);

        Assertions.assertThat(sb.toString()).isEqualTo("6개 일치 (2,000,000,000원) - 3개");
    }

    @DisplayName("당첨 통계 상세 내역을 반환한다. - 보너스 추가")
    @Test
    void returnOutputStatisticsBonus() {
        StringBuilder sb = new StringBuilder();
        Map<Statistics, Integer> testMap = new HashMap<>(){{
            put(FIVE_BONUS, 3);
        }};
        makeOutputStatistics(FIVE_BONUS, sb, testMap);

        Assertions.assertThat(sb.toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 3개");
    }
    
    @DisplayName("당첨 통계 상세 내역을 반환한다. - 여러개")
    @Test
    void returnOutputStatisticsMany() {
        StringBuilder sb = new StringBuilder();
        Map<Statistics, Integer> testMap = new HashMap<>(){{
            put(FIVE_BONUS, 3);
            put(FIVE, 2);
        }};

        makeOutputStatistics(FIVE_BONUS, sb, testMap);
        makeOutputStatistics(FIVE, sb, testMap);

        Assertions.assertThat(sb.toString()).isEqualTo(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 3개\n" +
                        "5개 일치 (1,500,000원) - 2개\n"
        );
    }

}