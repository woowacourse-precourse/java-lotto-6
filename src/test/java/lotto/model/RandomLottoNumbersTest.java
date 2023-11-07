package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomLottoNumbersTest {

    RandomLottoNumbers randomLottoNumbers;

    @BeforeEach
    public void beforeEach() {
        randomLottoNumbers = new RandomLottoNumbers();
    }

    @Test
    void 인자값_받고_랜덤_로또_번호_생성 () {
        int actual = randomLottoNumbers.createAutoLotto(8).length;
        assertThat(actual).isEqualTo(8);
    }

    @Test
    void 로또_번호_오름_차순_정렬 () {

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1,2,4,3,5,6));
        expected.add(List.of(23,13,34,2,1,3));
        expected.add(List.of(45,4,2,3,11,44));
        expected.add(List.of(3,2,16,4,14,6));
        expected.add(List.of(40,2,17,4,7,39));

        List<List<Integer>> actual = randomLottoNumbers.sortLotto(expected);

        for(int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
        }

        assertThat(actual.get(0)).isEqualTo(expected.get(0));
        assertThat(actual.get(1)).isEqualTo(expected.get(1));
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        assertThat(actual.get(3)).isEqualTo(expected.get(3));
        assertThat(actual.get(4)).isEqualTo(expected.get(4));
    }
}
