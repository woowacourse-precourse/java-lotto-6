package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class UserLottoTest {

    @Test
    public void 로또_번호를_정렬한다() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 12; i > 0; i -= 2) {
            numbers.add(i);
        }

        UserLotto userLotto = new UserLotto(numbers);

        assertThat(userLotto.numbers).isEqualTo(List.of(2, 4, 6, 8, 10, 12));
    }

}