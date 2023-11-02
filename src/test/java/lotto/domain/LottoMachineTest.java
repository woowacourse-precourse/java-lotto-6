package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;
import lotto.contents.ContentNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @DisplayName("LottoMachine이 유효한 로또 번호를 생성하는지 테스트합니다.")
    @Test
    void generateLottoCreatesValidNumbers() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        Lotto lotto = lottoMachine.generateLotto();
        Set<Integer> numbers = lotto.getNumbers().stream().collect(Collectors.toSet());

        // then
        assertEquals(ContentNumbers.LOTTO_NUMBERS_COUNT.getNumber(), numbers.size());
        assertTrue(numbers.stream().allMatch(number -> number >= ContentNumbers.LOTTO_MIN_NUMBER.getNumber()
                && number <= ContentNumbers.LOTTO_MAX_NUMBER.getNumber()));
    }
}