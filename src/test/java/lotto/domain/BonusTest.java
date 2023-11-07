package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {


    /*@ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("구매 로또 번호와 보너스 번호가 일치하는지 확인한다.")
    void checkSameNumber(int number) {
        // given
        Lotto
        Bonus bonus = new Bonus(number);
        List<Integer> ticket = List.of(1, 2, 3, 21, 26, 30);

        // when
        int bonusCount = bonus.sameTicket(ticket);

        // then
        assertThat(bonusCount).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 0, -1})
    @DisplayName("보너스 번호 범위에 일치하지 않는 숫자가 있으면 예외가 발생한다.")
    void createOverRange(int number) {
        assertThatThrownBy(() -> new Bonus(number))
                .isInstanceOf(IllegalArgumentException.class);
    }*/
}
