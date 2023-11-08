package lotto.enums;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.Lotto;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    WinningNumber winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new WinningNumber();
    }

    @Test
    @DisplayName("누적 금액 구하기")
    void calculatePrizeMoney() {
        // Given
        winningNumber.createWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumber.creatBonusNumber(10);

        List<Lotto> publishedLottos = new ArrayList<>(List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1,5,45,43,32,26)),
                new Lotto(Arrays.asList(15,23,43,41,35,24))
        ));

        // When
        winningNumber.checkMatchWinning(publishedLottos);

        Optional<Long> prizeMoney = Rank.calculatePrizeMoney();
        Assertions.assertThat(prizeMoney.orElse(null)).isEqualTo(2_000_000_000L);
    }
}