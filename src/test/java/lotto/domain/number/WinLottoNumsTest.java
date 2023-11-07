package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinLottoNumsTest {
    private WinLottoNumbers winLottoNums;

    @BeforeEach
    void setUp() {
        winLottoNums = new WinLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("추첨번호중 특정 값과 특정 index가 같은지 확인")
    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2", "4,3", "5,4", "6,5"})
    void isSameNumOfIndex(Integer value, Integer index) {
        // when
        Boolean result = winLottoNums.isSameNumOfIndex(value, index);

        // than
        assertThat(result).isTrue();
    }
}