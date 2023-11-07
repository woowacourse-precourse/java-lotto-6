package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

class UserLottoTest {
    @DisplayName("model_UserLotto_중복_없이_랜덤_넘버_생성")
    @Test
    public void model_UserLotto_create_number_not_duplicate() {
        int lottoQuantity = 3;
        UserLotto userLotto = new UserLotto(lottoQuantity);

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
}
