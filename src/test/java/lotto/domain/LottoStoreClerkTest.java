package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreClerkTest {

    @Test
    void calculateNumberOfTickets() {
        int expectedOutput = 5;
        assertThat(LottoStoreClerk.calculateNumberOfTickets(5000)).isEqualTo(expectedOutput);
    }

    @Test
    void checkLottoOrderAmount() {
        assertThatThrownBy(() -> LottoStoreClerk.checkLottoOrderAmount(100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoStoreClerk.checkLottoOrderAmount(1100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoStoreClerk.checkLottoOrderAmount(-10000))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1000원 미만이면 예외")
    @Test
    void checkMinimumAmount() {
        assertThatThrownBy(() -> LottoStoreClerk.checkMinimumAmount(100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoStoreClerk.checkMinimumAmount(-100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아니면 예외")
    @Test
    void checkDividableThousand() {
        assertThatThrownBy(() -> LottoStoreClerk.checkDividableThousand(1211))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoGenerater() {
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(List.of(1, 2, 3, 4, 5, 6));
        expectedOutput.add(List.of(11, 12, 13, 14, 15, 16));
        expectedOutput.add(List.of(21, 22, 23, 24, 25, 26));
        List<Lotto> generatedLottoTickets = LottoStoreClerk.lottoGenerater(3);
        assertThat(generatedLottoTickets.getClass()).isEqualTo(expectedOutput.getClass());
        assertThat(generatedLottoTickets.size()).isEqualTo(expectedOutput.size());
    }
}