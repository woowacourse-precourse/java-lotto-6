package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.IterableUtil.iterator;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class UserLottoTest {
    private static UserLotto userLotto;

    @DisplayName("model_UserLotto_초기화")
    @BeforeAll
    static void model_UserLotto_initialize() {
        int lottoQuantity = 3;
        userLotto = new UserLotto(lottoQuantity);
    }

    @DisplayName("model_UserLotto_중복_없이_랜덤_넘버_생성")
    @Test
    void model_UserLotto_create_number_not_duplicate() {
        for (List<Integer> userNumbers : userLotto.getUserLottoNumbers()) {
            assertThat(userNumbers.stream()
                    .filter(same -> Collections.frequency(userNumbers, same) > 1)
                    .count()).isEqualTo(0);
        }

        assertAll(
                () -> assertThat(userLotto.getUserLottoNumbers().size()).isEqualTo(3),
                () -> assertThat(userLotto.getUserLottoNumbers().get(0).size()).isEqualTo(6),
                () -> assertThat(userLotto.getUserLottoNumbers().get(1).size()).isEqualTo(6),
                () -> assertThat(userLotto.getUserLottoNumbers().get(2).size()).isEqualTo(6)
        );
    }

    @DisplayName("model_UserLotto_오름_차순_랜덤_넘버_생성")
    @Test
    void model_UserLotto_create_number_ASC() {
        for (List<Integer> userNumbers : userLotto.getUserLottoNumbers()) {
            Iterator<Integer> iterateUserNumbers = userNumbers.iterator();
            while (iterateUserNumbers.hasNext()) {
                assertThat(iterateUserNumbers.next().compareTo(iterateUserNumbers.next() + 1)).isEqualTo(-1);
            }
        }
    }
}
