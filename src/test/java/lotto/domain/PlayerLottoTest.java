package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerLottoTest {

    List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 숫자가 로또 숫자와 중복되면 예외가 발생한다.")
    @Test
    void createPlayerLottoWithDuplicateBonusNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerLotto(lottoNumbers, 6));
    }

    @DisplayName("보너스 숫자가 허용된 범위 밖의 숫자면 예외가 발생한다.")
    @Test
    void createPlayerLottoWithBonusNumberOutOfRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerLotto(lottoNumbers, 0));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerLotto(lottoNumbers, 46));
    }

    @DisplayName("플레이어 로또 생성에 성공한다.")
    @Test
    void createPlayerLottoSuccessfully() {
        Assertions.assertAll(() -> new PlayerLotto(lottoNumbers, 7));
    }

}
