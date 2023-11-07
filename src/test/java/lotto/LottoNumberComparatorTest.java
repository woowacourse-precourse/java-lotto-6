package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberComparatorTest {



    @Test
    void calculateMatchingNumbers() {

        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumberComparator lottoNumberComparator = new LottoNumberComparator(winningNumbers);

        //when
        int count =lottoNumberComparator.calculateMatchingNumbers(List.of(1, 2, 3, 4, 5, 6));
        //then
        Assertions.assertThat(count).isEqualTo(6);

    }
}