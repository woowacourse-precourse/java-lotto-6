package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("값이 유효하면 객체를 생성한다.")
    @Test
    void should_CreateWinningLotto_When_Valid() {
        WinningLotto winLotto = WinningLotto.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7, new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(winLotto).isNotNull();
    }
}
