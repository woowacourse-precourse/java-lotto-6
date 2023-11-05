package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void lottos_생성자_테스트() {
        List<List<Integer>> numbers = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16, 17, 18)
        ));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));

        assertNotNull(lottos);

        List<List<Integer>> lottoNumbers = lottos.getLottos().stream().map(Lotto::getNumbers).toList();
        assertEquals(numbers, lottoNumbers);
    }
}
