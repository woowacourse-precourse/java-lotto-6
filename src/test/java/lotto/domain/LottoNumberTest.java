package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.DuplicateNumberException;
import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("보너스 번호를 뽑지 않는다면 예외 발생")
    @Test
    void pickBonusNumber() {
        assertThatThrownBy(() -> new LottoNumber(Integer.parseInt("")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 6개 숫자 중에 중복되는 숫자가 있다면 예외 발생")
    @Test
    void duplicateBonusNumber() {
        int duplicated = 5;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, duplicated, 6));
        LottoNumber lottoNumber = new LottoNumber(duplicated);

        assertThatThrownBy(() -> new WinningLotto(lotto, lottoNumber))
                .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니다.")
    @ParameterizedTest
    @ValueSource(ints = {46, 85, -1, 299})
    void outOfRange(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("보너스 번호를 두 개이상 뽑는다.")
    @Test
    void pickTwoBonusNumbers() {
        assertThatThrownBy(() -> new LottoNumber(Integer.parseInt("2,2")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
