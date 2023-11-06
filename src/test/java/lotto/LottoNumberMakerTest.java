package lotto;

import static lotto.LottoNumbersMaker.getLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberMakerTest {

    @Test
    @DisplayName("getLottoNumbers 값 중복 검증 테스트")
    void validateGetLottoNumbersByNotDuplicated() {

        List<Integer> numbers = getLottoNumbers();

        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        assertThat(notDuplicateNumbers.size()).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("getLottoNumbers 값 정렬 검증 테스트")
    void validateGetLottoNumbersBySorted() {

        List<Integer> numbers = getLottoNumbers();
        List<Integer> sortedNumber = new ArrayList<>();

        sortedNumber.addAll(numbers);

        Collections.sort(sortedNumber);

        assertThat(numbers).isEqualTo(sortedNumber);
    }
}
