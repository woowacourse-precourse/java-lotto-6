package lotto.domain.user;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private LottoEnvelop lottoEnvelop;
    private Lotto lotto_1;
    private Lotto lotto_2;
    private Lotto lotto_3;

    @BeforeEach
    void setUp() {
        user = new User();
        lottoEnvelop = new LottoEnvelop();
        lotto_1 = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        lotto_2 = new Lotto(List.of(7, 6, 5, 4, 3, 2));
        lotto_3 = new Lotto(List.of(8, 7, 6, 5, 4, 3));
    }

    @DisplayName("로또를 보여준다.")
    @Test
    void showLottoEnvelop() {
        lottoEnvelop.add(lotto_1);
        lottoEnvelop.add(lotto_2);
        lottoEnvelop.add(lotto_3);

        // when
        user.takeLottoEnvelop(lottoEnvelop);
        StringBuilder result = user.showLottoEnvelop();

        // than
        assertThat(result).contains(
                "[1, 2, 3, 4, 5, 6]\n" +
                        "[2, 3, 4, 5, 6, 7]\n" +
                        "[3, 4, 5, 6, 7, 8]\n"
        );
    }
}