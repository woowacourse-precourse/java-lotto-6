package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserLottoTest {
    @DisplayName("model_UserLotto_3_입력_했을_때")
    @Test
    public void model_UserLotto_3_input() {
        int lottoQuantity = 3;
        List<Integer> countFrequency = new ArrayList<>();
        UserLotto userLotto = new UserLotto(lottoQuantity);

        for (List<Integer> userNumbers : userLotto.getUserNumbers()) {
            int n = userNumbers.get(0);
            countFrequency.add((int) userNumbers.stream()
                    .filter(num -> num == n)
                    .count());
        }

        assertAll(
                () -> assertThat(userLotto.getUserNumbers().size()).isEqualTo(3),
                () -> assertThat(userLotto.getUserNumbers().get(0).size()).isEqualTo(6),
                () -> assertThat(userLotto.getUserNumbers().get(1).size()).isEqualTo(6),
                () -> assertThat(userLotto.getUserNumbers().get(2).size()).isEqualTo(6),
                () -> assertThat(countFrequency).containsOnly(
                        1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1)
        );
    }
}
