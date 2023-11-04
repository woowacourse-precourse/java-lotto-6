package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {


    @ParameterizedTest
    @DisplayName("BonusNumber가 Lotto와 중복되는 숫자라면 예외가 발생헌다.")
    @ValueSource(ints = {1,2,3})
    void WinningLott_생성_예외(int number) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("BonusNumber가 Lotto와 중복되지 않는다면 생성 성공")
    @ValueSource(ints = {7,30,45})
    void WinningLotto_생성_성공(int number) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertDoesNotThrow(() -> new WinningLotto(lotto, bonusNumber));
    }

    // todo : 값이 제대로 생성되었는지?
}