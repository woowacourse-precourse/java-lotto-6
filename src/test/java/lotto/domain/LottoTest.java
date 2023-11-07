package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 현재 로또가 6개의 숫자를 포함하고 있지 않습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또에 중복된 숫자가 포함되어 있습니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("로또에 1부터 45사이가 아닌 숫자가 포함되어 있다면 예외가 발생한다.")
    public void createLottoByNumberRange() throws Exception {
        //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 55, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 포함되어야 합니다.");
    }

    @Test
    @DisplayName("발행된 로또의 숫자를 오름차순으로 조회한다.")
    public void getLottoNumberTest() throws Exception {
        // given
        ArrayList arrayList = new ArrayList(List.of(1, 2, 3, 4, 9, 5));
        Lotto lotto = new Lotto(arrayList);

        // when


        // then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 9));
    }

    @Test
    @DisplayName("로또 두개를 비교할 때, 몇개의 원소가 포함되어 있는가?")
    public void rottosMatchCountTest() throws Exception {
        // given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = new ArrayList<>(List.of(8, 7, 3, 2, 42, 43));
        Lotto winningLotto = new Lotto(winningNumbers);
        Lotto buyLotto = new Lotto(numbers);

        // when
        int count = buyLotto.matchCount(winningLotto);

        // then
        Assertions.assertThat(count).isEqualTo(2);
    }
}