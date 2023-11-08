package lotto;

import java.util.List;
import lotto.domain.BroadCastingStation;
import lotto.domain.Lotto;
import lotto.error.LottoErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BroadCastingStationTest {
    @Test
    @DisplayName("로또의 숫자와 보너스 번호가 겹치면 예외가 발생한다")
    void validateLottoAndBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 5;
        BroadCastingStation broadCastingStation = new BroadCastingStation();
        Assertions.assertThatThrownBy(() -> {
                    broadCastingStation.drawLotto(lotto, bonus);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.BONUS_DUPLICATED);
    }
}