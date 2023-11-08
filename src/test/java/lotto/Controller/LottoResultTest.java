package lotto.Controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {
    private static LottoResult lottoResult;
    @BeforeAll
    public static void setup() {
        lottoResult = new LottoResult(null,null,null);
    }


    @DisplayName("로또 번호와 로또 정답을 비교하여 포함하는 숫자 개수 반환. (보너스 번호 포함 x)")
    @Test
    void matchCount() {
        final List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<Integer> numbers = Arrays.asList(8,2,3,4,5,6);

        int match = lottoResult.matchCount(lotto,numbers);

        assertEquals(5,match);

    }

    @DisplayName("로또 번호와 로또 정답을 비교하여 결과 반환.")
    @Test
    void matchLotto() {
        final ArrayList<List<Integer>> lottos = new ArrayList<>();
        lottos.add(Arrays.asList(1, 10, 7, 6, 4, 2));
        lottos.add(Arrays.asList(44, 20, 18, 15, 13, 7));

        final List<Integer> numbers = Arrays.asList(1,6,44,3,18,15);

        final Integer bonus = 2;

        List<Integer> result = lottoResult.matchLotto(lottos,numbers,bonus);

        assertThat(result).containsExactly(0,0,0,0,1);
    }
}