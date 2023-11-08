package lotto.view;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersDisplayTest {
    @DisplayName("로또 출력 테스트.")
    @Test
    void printLottoNums() {
        List<Integer> numbers = LottoGenerator.getLottoNumbers();
        LottoNumbersDisplay.displayLotto(numbers);
    }
}