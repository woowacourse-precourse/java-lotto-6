package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(3000);
    }

    @DisplayName("개수만큼 로또를 생성한다.")
    @Test
    void createLottoByCount() {
        int count = 3;

        assertThat(count).isEqualTo(player.generateLotteries().size());
    }

    @DisplayName("구매 금액을 로또 개수로 변환햔다.")
    @Test
    void convertAmountToLottoCount() {
        int count = 3;

        assertThat(count).isEqualTo(player.convertToUnit());
    }
}
