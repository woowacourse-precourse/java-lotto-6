package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호가 1에서 45 사이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 해당 번호가 포함되어 있는지 확인한다.")
    @Test
    void checkContainsNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 4;

        assertThat(lotto.containNumber(number)).isEqualTo(true);
    }

    @DisplayName("로또 등수를 확인한다.")
    @Test
    void checkLottoRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        int bonusNumber = 6;

        assertThat(lotto.checkRank(winningNumber, bonusNumber))
                .isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 당첨 결과를 확인한다.")
    @Test
    void checkLottoResult() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        Lotto winingNumber = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        int bonusNumber = 6;

        Map<LottoRank, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoRank.FIRST, 1);
        expectedResult.put(LottoRank.SECOND, 1);
        expectedResult.put(LottoRank.THIRD, 0);
        expectedResult.put(LottoRank.FOURTH, 1);
        expectedResult.put(LottoRank.FIFTH, 0);
        expectedResult.put(LottoRank.MISS, 0);

        LottoResult result = new LottoResult(lottos, winingNumber, bonusNumber);

        assertThat(result.getResult()).isEqualTo(expectedResult);


    }
}