package lotto;

import static lotto.domain.LottoNumbersMaker.getLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberMakerTest {

    @DisplayName("getLottoNumbers 값 정렬 검증 테스트")
    @Test
    void validateGetLottoNumbersBySorted() {

        List<Integer> numbers = getLottoNumbers();
        List<Integer> sortedNumber = new ArrayList<>();

        sortedNumber.addAll(numbers);

        Collections.sort(sortedNumber);

        assertThat(numbers).isEqualTo(sortedNumber);
    }
}
