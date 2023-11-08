package lotto.domain.lotto;

import lotto.service.dto.LottoResultDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_매칭() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,7);
        int bonusNumber = 8;

        LottoResultDto lottoResultDto = lotto.matchWithWinningNumbersAndBonusNumber(winningNumbers,bonusNumber);
        Assertions.assertEquals(lottoResultDto, new LottoResultDto(5, 1));
    }

    @Test
    void 로또_번호_조회() {
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> getNumbersResult = lotto.getNumbers();

        Assertions.assertEquals(lottoNumbers, getNumbersResult);
    }
}