package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawnNumbersTest {

    private DrawnNumbers drawnNumbers;

    @BeforeEach
    public void setUp() {
        Lotto lotto = Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        ));
        WinningNumbers winningNumbers = WinningNumbers.from(lotto);
        BonusNumber bonusNumber = BonusNumber.of(winningNumbers, Number.valueOf(10));
        drawnNumbers = DrawnNumbers.from(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("같은 값을 가진 래퍼 클래스의 중복을 제거한다.")
    void Number_중복_제거_테스트() {
        // given
        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(2));

        // then
        int count = (int) numbers.stream()
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨된 번호가 3개이고 보너스 번호가 있는 경우를 검증한다.")
    void 당첨된_번호_3개_보너스_번호가_있는_경우_compare() {
        // given
        Lotto lotto = Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(7),
                Number.valueOf(8),
                Number.valueOf(10)
        ));

        int expectedWinningCount = 3;
        boolean expectedHasBonusNumber = true;
        LottoResultDto expectedLottoResultDto = LottoResultDto.of(
                expectedWinningCount,
                expectedHasBonusNumber);

        // when
        LottoResultDto actualLottoResultDto = drawnNumbers.compare(lotto);

        // then
        assertEquals(expectedLottoResultDto.getWinningCount(), actualLottoResultDto.getWinningCount());
        assertEquals(expectedLottoResultDto.hasBonusNumber(), actualLottoResultDto.hasBonusNumber());
    }

    @Test
    @DisplayName("당첨된 번호가 6개이고 보너스 번호가 없는 경우를 검증한다.")
    void 당첨된_번호_6개_보너스_번호가_없는_경우_compare() {
        // given
        Lotto lotto = Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        ));

        int expectedWinningCount = 6;
        boolean expectedHasBonusNumber = false;
        LottoResultDto expectedLottoResultDto = LottoResultDto.of(
                expectedWinningCount,
                expectedHasBonusNumber);

        // when
        LottoResultDto actualLottoResultDto = drawnNumbers.compare(lotto);

        // then
        assertEquals(expectedLottoResultDto.getWinningCount(), actualLottoResultDto.getWinningCount());
        assertEquals(expectedLottoResultDto.hasBonusNumber(), actualLottoResultDto.hasBonusNumber());
    }
}
