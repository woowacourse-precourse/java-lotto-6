package lotto.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("구입 금액에 빈 문자열이나 NULL이 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByEmptyString() {
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 문자가 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByNotNumber() {
        assertThatThrownBy(() -> new User("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 1000원 단위가 아닌 숫자가 들어오면 예외가 발생한다.")
    @Test
    void setBonusNumberByNotDivisibleBy1000() {
        assertThatThrownBy(() -> new User("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 입력하면 금액에 맞게 로또를 생성한다.")
    @Test
    void checkLottoCount() {
        User user = new User("1000");
        assertEquals(1, user.getLottos().size());
        user = new User("2000");
        assertEquals(2, user.getLottos().size());
        user = new User("3000");
        assertEquals(3, user.getLottos().size());
    }

    @DisplayName("로또를 구입하면 오름차순으로 정렬한다.")
    @Test
    void checkLottoSort() {
        User user = new User("1000");
        List<Lotto> lottos = user.getLottos();
        for(int i = 0; i < lottos.size() - 1; i++) {
            assertTrue(lottos.get(i).getNumbers().get(0) < lottos.get(i + 1).getNumbers().get(0));
        }
    }

}