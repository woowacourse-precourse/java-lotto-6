package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("로또번호와 보너스 번호가 중복되지 않는다면, 정상적으로 생성")
    void createLottoResultByUsingNotDuplicateBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int count = 7;
        LottoResult result = new LottoResult(lotto, count);

        Assertions.assertThat(result.getBonusNumber())
                .isEqualTo(count);
    }

    @Test
    @DisplayName("로또번호와 보너스 번호가 중복되지 않는다면, 예외 발생")
    void createLottoResultByUsingDuplicateBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int count = 6;

        Assertions.assertThatThrownBy(() -> new LottoResult(lotto, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
    }


}