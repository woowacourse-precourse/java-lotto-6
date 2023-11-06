package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoComparatorTest {

    @Test
    void getPlace() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWithBonus answer = new LottoWithBonus(lotto, 45);
        List<Lotto> allLotto = new ArrayList<>();
        allLotto.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 15, 16)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        allLotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        Map<LottoResult, Integer> allResult = new LinkedHashMap<>();
        for (LottoResult init : LottoResult.values()) {
            allResult.put(init, 0);
        }
        for (Lotto l : allLotto) {
            LottoResult result = LottoComparator.getPlace(answer, l);
            allResult.put(result, allResult.get(result) + 1);
        }

        // then
        for (var i : allResult.entrySet()) {
            assertThat(i.getValue()).isEqualTo(1);
        }
    }
}