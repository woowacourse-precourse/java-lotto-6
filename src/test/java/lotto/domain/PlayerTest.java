package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private static Player player = new Player(5);

    @DisplayName("구매 개수만큼 로또가 생성되었는지 확인한다.")
    @Test
    void checkTheNumberOfLottoCreated() {
        int makeLottoCount = 10;
        assertThat(new Player(makeLottoCount).lottos.size())
                .isEqualTo(makeLottoCount);
    }


}
