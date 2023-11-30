package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @ParameterizedTest
    @DisplayName("로또 넘버 contains 참 테스트")
    @ValueSource(ints = {1, 3, 4})
    public void containsTrueTest(int source) {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.contains(source)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버 contains 참 테스트")
    @ValueSource(ints = {1, 3, 4})
    public void containsLottoNumberTrueTest(int source) {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.contains(new LottoNumber(source))).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버 contains 거짓 테스트")
    @ValueSource(ints = {7, 8, 9})
    public void containsFalseTest(int source) {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.contains(source)).isEqualTo(false);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버 contains 거짓 테스트")
    @ValueSource(ints = {7, 8, 9})
    public void containsLottoNumberFalseTest(int source) {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.contains(new LottoNumber(source))).isEqualTo(false);
    }

    @DisplayName("같은 로또 번호를 가진 로또들은 같은 로또이다.")
    @Test
    void equalsTrueTest() {
        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 6, 2, 3, 4)));
        assertThat(lotto1.equals(lotto2)).isEqualTo(true);

    }

    @DisplayName("하나라도 다른 로또 번호를 가진 로또들은 다른 로또이다.")
    @Test
    void equalsFalseTest() {
        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 6, 2, 10, 4)));
        assertThat(lotto1.equals(lotto2)).isEqualTo(false);

    }

    @DisplayName("로또는 오름차순으로 저장된다.")
    @Test
    void sortAscTest() {
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 5, 6, 2, 10, 4)));
        assertThat(lotto2.getNumbers()).isEqualTo(List.of(1, 2, 4, 5, 6, 10));

    }
}