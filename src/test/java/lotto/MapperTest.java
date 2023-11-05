package lotto;

import lotto.domain.common.Money;
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
}
