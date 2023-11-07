package lotto.service;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumbersTest {

    private final LottoNumbers lottoNumbers = new LottoNumbers();
    @Test
    @DisplayName("랜덤한 6개의 로또 번호가 생성되어 오름차순으로 정렬")
    void createPlayerLotto() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoNumbers.createPlayerLotto()).containsExactly(8, 21, 23, 41, 42, 43);
                },
                List.of(8, 21, 23, 41, 42, 43)

        );

    }

    @Test
    void 당첨번호를_5개만_입력() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoNumbers.validateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 당첨번호_콤마를_제대로_입력하지_않음() {
        String input = "1,2,3,4,5,,";
        assertThatThrownBy(() -> lottoNumbers.validateWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}