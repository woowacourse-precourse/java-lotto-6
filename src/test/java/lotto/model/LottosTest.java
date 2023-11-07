package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    @DisplayName("로또리스트에 잘 담기는지 확인")
    @Test
    void testLottos() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        Lottos lottos = new Lottos(lottoList);

        int totalNumbers = 0;
        for (Lotto lotto : lottos) {
            for (int number : lotto) {
                totalNumbers += number;
            }
        }

        assertEquals(42, totalNumbers); // 총 숫자 수를 확인
    }
}