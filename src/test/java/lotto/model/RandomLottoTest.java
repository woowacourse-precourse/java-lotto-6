package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomLottoTest {

    @DisplayName("랜덤 숫자 정렬 확인")
    @Test
    void listSort() {
        RandomLotto randomLotto = new RandomLotto();
        List<Integer> sortNumbers = randomLotto.listSort(List.of(1, 11, 5, 24, 3, 7));
        assertThat(sortNumbers).isEqualTo(List.of(1, 3, 5, 7, 11, 24));
    }
}