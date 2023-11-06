package controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @DisplayName("로또 번호가 당첨 번호와 몇 개가 겹치는지 반환한다.")
    @Test
    void 로또_번호_당첨_번호_중복_있음() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(3,4,5,7,6,8);

        int result = LottoGame.numOfMatchNum(lottoNumbers, winningNumbers);

        Assertions.assertThat(result).isEqualTo(4);
    }

    @DisplayName("로또 번호가 당첨 번호와 몇 개가 겹치는지 반환한다.")
    @Test
    void 로또_번호_당첨_번호_중복_없음() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningNumbers = Arrays.asList(7,8,9,10,11,12);

        int result = LottoGame.numOfMatchNum(lottoNumbers, winningNumbers);

        Assertions.assertThat(result).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 있으면 true를 반환한다.")
    @Test
    void 로또번호에_보너스_번호_있음() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 5;

        boolean result = LottoGame.ifBonusNumEqual(lottoNumbers, bonusNum);

        Assertions.assertThat(result).isEqualTo(true);
    }

    @DisplayName("보너스 번호가 없으면 false 반환")
    @Test
    void 로또번호에_보너스_번호_없음() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 20;

        boolean result = LottoGame.ifBonusNumEqual(lottoNumbers, bonusNum);

        Assertions.assertThat(result).isEqualTo(false);
    }
}
