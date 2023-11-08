package lotto.domain;

import lotto.domain.lottery.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMessageBuilderTest {
    private LotteryMessageBuilder lotteryMessageBuilder;

    @BeforeEach
    void setUp() {
        lotteryMessageBuilder = new LotteryMessageBuilder();
    }

    @DisplayName("구매한 로또의 개수와 각 로또 번호를 출력한다.")
    @Test
    void returnLottoList() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        // When
        String expectedMessage = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";
        String actualMessage = lotteryMessageBuilder.returnLottoList(lottos);

        // Then
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}