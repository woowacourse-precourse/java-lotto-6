package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("구입 금액에 숫자 외의 문자가 입력되면 예외를 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new Money("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000 원 미만(0 원)이라면 예외를 발생한다.")
    @Test
    void createBonusByOverRange() {
        assertThatThrownBy(() -> new Money("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액의 단위가 1000 원이 아니라면(1111 원) 예외를 발생한다.")
    @Test
    void createBonusByDuplicatedAnswer() {
        assertThatThrownBy(() -> new Money("1111"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 5000 원이라면 구매한 로또 개수가 5 개이다.")
    @Test
    void lottoCountByMoney() {
        assertThat(new Money("5000").countLottos()).isEqualTo(5);
    }
}