package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoWithSameBonusNumbers(){
        //given
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,7,8));
        int bonusNumber = 1;

        //when //then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("내가 산 로또와 당첨로또가 얼마나 일치하는지 점수를 알려준다.")
    @Test
    void getScore(){
        //given
        Lotto myLottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,7,8));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 9);

        //when
        int score = winningLotto.getScore(myLottoNumbers);

        //then
        assertThat(score).isEqualTo(4);
    }

}