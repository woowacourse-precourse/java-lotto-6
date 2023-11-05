package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @DisplayName("일치개수, 보너스번호, 발행로또 번호를 입력받아 알맞은 enum을 반환한다.")
    @Test
    void returnStatisticsTest() {
        Statistics statistics = Statistics.getStatistics(3, 22, Arrays.asList(1, 2, 3, 4, 22, 33));

        Assertions.assertThat(statistics).isEqualTo(Statistics.THREE);
    }

    @DisplayName("일치개수, 보너스번호, 발행로또 번호를 입력받아 보너스 enum을 반환한다.")
    @Test
    void returnBonusStatisticsTest() {
        Statistics statistics = Statistics.getStatistics(4, 22, Arrays.asList(1, 2, 3, 4, 22, 33));

        Assertions.assertThat(statistics).isEqualTo(Statistics.FIVE_BONUS);
    }

}