package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import java.util.List;

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

    @Test
    void 알맞은등수_반환테스트(){
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        Lotto firstPlaceLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto secondPlaceLotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto thirdPlaceLotto = new Lotto(List.of(1,2,3,4,5,8));
        Lotto forthPlaceLotto = new Lotto(List.of(1,2,3,4,9,10));
        Lotto fifthPlaceLotto = new Lotto(List.of(1,2,3,10,11,12));
        Lotto none1PlaceLotto = new Lotto(List.of(1,2,10,11,12,13));
        Lotto none2PlaceLotto = new Lotto(List.of(1,10,11,12,13,14));
        Lotto none3PlaceLotto = new Lotto(List.of(10,11,12,13,14,15));


        Assertions.assertThat(Place.FIRST).isEqualTo(firstPlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.SECOND).isEqualTo(secondPlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.THIRD).isEqualTo(thirdPlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.FORTH).isEqualTo(forthPlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.FIFTH).isEqualTo(fifthPlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.NONE).isEqualTo(none1PlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.NONE).isEqualTo(none2PlaceLotto.whichPlace(correctLotto,bonusNumber));
        Assertions.assertThat(Place.NONE).isEqualTo(none3PlaceLotto.whichPlace(correctLotto,bonusNumber));
    }


}