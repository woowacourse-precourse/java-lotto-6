package lotto.model;

import static lotto.constant.Magic.WINNING_NUM_EX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("보너스 번호 입력 시 1~45 사이 양의 정수가 아니거나 당첨번호와 중복 된다면 예외 발생 시킴 ")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "!@", "qw", "0", "-1", "46"})
    void validateBonus(String price) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : WINNING_NUM_EX) {
            //    WINNING_NUM_EX = {"1", "2", "3", "4", "5", "21"};
            numbers.add(Integer.parseInt(num));
        }
        assertThatThrownBy(() -> new BonusNumber(price, new Lotto(numbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}