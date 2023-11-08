package lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import lotto.domain.generator.WinningLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoErrorTest {
    WinningLottoGenerator winningLottoGenerator;

    @BeforeEach()
    void setUp() {
        winningLottoGenerator = new WinningLottoGenerator();
    }

    @DisplayName("로또 번호가 0이상의 정수가 아닌 것을 포함하는 경우 false를 반환한다.")
    @Test
    void createLottoNotDecimal() {
        assertFalse(() -> winningLottoGenerator.validate(List.of("1", "2", "3", "invlid", "5", "6")));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 false를 반환한다.")
    @Test
    void createLottoByOverSize() {
        assertFalse(() -> winningLottoGenerator.validate(List.of("1", "2", "3", "4", "5")));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 false를 반환한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertFalse(() -> winningLottoGenerator.validate(List.of("1", "2", "3", "4", "5", "5")));
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 false를 반환한다.")
    @Test
    void createLottoNotInRangeNumber() {
        assertFalse(() -> winningLottoGenerator.validate(List.of("1", "2", "3", "4", "5", "48")));
    }
}
