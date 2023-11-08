package lotto.controller;

import lotto.AppConfig;
import lotto.Lotto;
import lotto.model.WinLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetWinLottoImplTest {

    AppConfig appConfig = new AppConfig();
    GetWinLotto getWinLotto = appConfig.getWinLotto();
    Lotto winLotto = getWinLotto.validWinNumber("1,2,3,7,34,45");

    @Test
    void 유효한_로또_당첨_번호_입력(){
        Lotto winLotto = getWinLotto.validWinNumber("1,2,3,7,34,45");
        Assertions.assertThat(winLotto.getNumbers()).containsExactly(1,2,3,7,34,45);
    }

    @Test
    void 숫자가_아닌_로또_당첨_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validWinNumber("오잉,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자연수_아닌_로또_당첨_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validWinNumber("1,2,3,3.5,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위가_아닌_로또_당첨_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validWinNumber("47,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위가_아닌_로또_당첨_번호_입력2(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validWinNumber("-8,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_보너스_번호_입력(){
        int bonusNum= getWinLotto.validBonusNumber("43",winLotto);
        Assertions.assertThat(bonusNum).isEqualTo(43);

    }

    @Test
    void 자연수_아닌_보너스_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validBonusNumber("3.5",winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위가_아닌_보너스_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validBonusNumber("47",winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위가_아닌_보너스_번호_입력2(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validBonusNumber("-1",winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_보너스_번호_입력2(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validBonusNumber("테스트",winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_보너스_번호_입력(){
        Assertions.assertThatThrownBy(()-> getWinLotto.validBonusNumber("3",winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_당첨_번호(){
        Lotto winNumber = getWinLotto.validWinNumber("1,4,5,17,42,43");
        int bonusNum= getWinLotto.validBonusNumber("10",winNumber);
        WinLotto winLotto = new WinLotto(winNumber,bonusNum);
        Assertions.assertThat(winLotto.getWinLottoNumbers()).containsExactly(1,4,5,17,42,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(0).getNumbers())
                .containsExactly(4,5,10,17,42,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(1).getNumbers())
                .containsExactly(1,5,10,17,42,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(2).getNumbers())
                .containsExactly(1,4,10,17,42,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(3).getNumbers())
                .containsExactly(1,4,5,10,42,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(4).getNumbers())
                .containsExactly(1,4,5,10,17,43);
        Assertions.assertThat(winLotto.getSecondPlaceLottos().get(5).getNumbers())
                .containsExactly(1,4,5,10,17,42);
    }
}
