package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoByPlayerTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoByPlayer(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new LottoByPlayer(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new LottoByPlayer(List.of(1, 2, 3, 50, 0, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호의 입력이 올바르지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""," ","a","-1","1-","0","46","1","2","3","4","5","6"})
    void createInvalidBonusNumber(String bonusNumber){
        LottoByPlayer lottoByPlayer = new LottoByPlayer(List.of(1,2,3,4,5,6));
        assertThatThrownBy(()-> lottoByPlayer.validateBonusNumber(bonusNumber, new ArrayList<>(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}