package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

    @Test
    @DisplayName("여러 개의 로또를 하나의 문자열로 만들기")
    void testToString() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Integer> numbers = new ArrayList<>(List.of(1 + i, 2 + i, 3 + i, 4 + i, 5 + i, 6 + i));
            Collections.sort(numbers);

            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        LottoBundle lottoBundle = new LottoBundle(lottos);
        assertThat(lottoBundle.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"
                        + "[2, 3, 4, 5, 6, 7]\n"
                        + "[3, 4, 5, 6, 7, 8]\n"
                        + "[4, 5, 6, 7, 8, 9]\n"
                        + "[5, 6, 7, 8, 9, 10]");
    }
}