package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @BeforeEach
    void beforeEach() {

    }

    @DisplayName("당첨 로또번호와 보너스번호 입력값의 범위가 1~45 를 넘으면 예외 발생")
    @Test
    void createWinninglottoOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(0, 2, 3, 4, 5, 6), 48))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 로또번호와 보너스번호 입력값이 중복되면 예외 발생")
    @Test
    void createWinninglottoDuplicated() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 로또번호의 입력값이 7개 이상일때 오류 발생")
    @Test
    void createWinninglottoOutOfCount() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 45))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호 배열 받아오기 구현")
    @Test
    void getWinningLottos() {
        //given
        List<Integer> winninglottos = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winninglottos, 7);
        //when
        List<Integer> getWinningLottos = winningLotto.getWinninglottos();
        //then
        assertThat(getWinningLottos).isEqualTo(winninglottos);
    }

    @DisplayName("보너스 번호  받아오기 구현")
    @Test
    void getBonusLottos() {
        //given
        List<Integer> winninglottos = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winninglottos, 7);
        //when
        int bonusNumber = winningLotto.getBonusNumber();
        //then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("한개의 로또와 당첨 번호와 비교하여 맞는 개수만큼 리턴 구현")
    @Test
    void compareOneLottoAndWinningLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningLottos = Arrays.asList(1, 2, 3, 11, 12, 13);
        WinningLotto winningLotto = new WinningLotto(winningLottos, 7);

        int count = winningLotto.compareOneLottoAndWinningLotto(lotto, winningLottos);

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 숫자와 로또의 숫자가 같은것이 있는지 비교 하도록 구현")
    void compareWithBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winninglottos = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winninglottos, 7);
        //when
        boolean compare = winningLotto.compareWithBonusNumber(lotto, winningLotto.getBonusNumber());
        //then
        assertThat(compare).isEqualTo(false);

    }

    @DisplayName("로또와 당첨번호를 비교해서 당첨된 등수를 리턴하도록 구현")
    @Test
    void checkRewardBonusOrNot() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winninglottos = Arrays.asList(1, 2, 3, 4, 5, 10);
        WinningLotto winningLotto = new WinningLotto(winninglottos, 6);

        Reward reward = winningLotto.checkRewardBonusOrNot(winningLotto, lotto);

        assertThat(reward).isEqualTo(Reward.MATCH_FIVE_BONUS);
    }
}