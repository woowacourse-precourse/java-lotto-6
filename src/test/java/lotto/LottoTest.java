package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0일 경우")
    @Test
    void createMoneyByDecimal() {
        assertThatThrownBy(() -> new Asset(2.5D))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 100장 넘게 구매할 경우")
    @Test
    void createMoneyByOverflow() {
        assertThatThrownBy(() -> new Player(new Asset(200000D)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위가 아닐 경우")
    @Test
    void createBonusNumByOutOfRange() {
        assertThatThrownBy(() -> new LottoGame( new Lotto(List.of(1,2,3,4,5)), 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위가 아닐 경우")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}