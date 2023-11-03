package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순으로 정렬하여 가져온다.")
    @Test
    void 로또번호_오름차순(){
        //given
        List<Integer> lottoNumbers=new ArrayList<>(List.of(6,4,1,3,5,2));

        //when
        Lotto lotto=new Lotto(lottoNumbers);

        //then
        assertThat(lotto.getSortingNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("로또 번호들 중 1부터 45까지의 값이 아닌것이 있는경우 예외처리.")
    @Test
    void 로또번호_범위이탈_예외처리(){
        assertThatThrownBy(() -> new Lotto(List.of(4, 8, 43, 27, 46, 9)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 8, 43, 27, 37, 9)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(4, 8, 43, 27, -5, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}