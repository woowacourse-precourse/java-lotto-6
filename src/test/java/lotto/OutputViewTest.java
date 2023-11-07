package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputViewTest {
    @DisplayName("rank에 해당하는 것 정상적 출력 테스트")
    @Test
    void rankMappingTest() {
        LottoRank rank = LottoRank.FIRST;

        Assertions.assertThat(rank.getHit()).isEqualTo(6);
        Assertions.assertThat(rank.getWinningMoney()).isEqualTo(2_000_000_000);
        Assertions.assertThat(rank.getMessage()).isEqualTo("6개 일치 (2,000,000,000원) - ");
    }
}
