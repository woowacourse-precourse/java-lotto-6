package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("로또번호와 보너스 번호가 중복되지 않는다면, 정상적으로 생성")
    void createLottoResultByUsingNotDuplicateBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int count = 7;
        LottoResult result = new LottoResult(lotto, count);

        assertThat(result.getBonusNumber())
                .isEqualTo(count);
    }

    @Test
    @DisplayName("로또번호와 보너스 번호가 중복되지 않는다면, 예외 발생")
    void createLottoResultByUsingDuplicateBonusNumber() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numberList);
        int count = 6;

        assertThatThrownBy(() -> new LottoResult(lotto, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
    }

}