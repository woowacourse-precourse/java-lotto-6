package lotto;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MapperTest {

    @DisplayName("입력이 주어지면, 돈 객체로 변환할 수 있다.")
    @Test
    void mapToMoney() {
        Money money = Mapper.mapToMoney("1000");

        assertThat(money).isEqualTo(Money.from(1000));
    }

    @DisplayName("알 수 없는 문자열의 경우, 돈 객체로 변환할 수 없다.")
    @Test
    void checkInputNonNull() {
        assertThatThrownBy(() -> Mapper.mapToMoney(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 입력입니다.");
    }

    @DisplayName("숫자 형식이 아닌 경우, 돈 객체로 변환할 수 없다.")
    @Test
    void numberFormat() {
        assertThatThrownBy(() -> Mapper.mapToMoney("123kk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식으로 입력해주세요.");
    }

    @DisplayName("입력이 주어지면, 로또 객체로 변환할 수 있다.")
    @Test
    void mapToLotto() {
        Lotto lotto = Mapper.mapToLotto("1,2,3,4,5,6");

        assertThat(lotto.getNumbers())
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("알 수 없는 문자열의 경우, 로또 객체로 변환할 수 없다.")
    @Test
    void checkInputNonNullForLotto() {
        assertThatThrownBy(() -> Mapper.mapToLotto(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 입력입니다.");
    }

    @DisplayName("각 숫자가 숫자 형식이 아닌 경우, 로또 객체로 변환할 수 없다.")
    @Test
    void numberFormatForLotto() {
        assertThatThrownBy(() -> Mapper.mapToLotto("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 쉼표로 분리한 형식으로 입력해주세요. ex) 1,2,3,4,5,6");
    }
}
