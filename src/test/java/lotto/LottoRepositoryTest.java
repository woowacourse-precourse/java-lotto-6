package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoRepositoryTest{
    LottoRepository lottoRepository=new LottoRepository();
    @DisplayName("보너스 번호가 당첨 번호와 겹치는 오류")
    @Test
    void bonusNumberInputError(){
        lottoRepository.setWinningLotto(new Lotto(List.of(1,2,3,4,5,6)));
        Assertions.assertFalse(lottoRepository.setBonusNum(6));
    }

    @DisplayName("당첨 번호가 보너스 번호와 겹치는 오류")
    @Test
    void winningLottoInputError(){
        lottoRepository.setBonusNum(1);
        Assertions.assertFalse(lottoRepository.setWinningLotto(new Lotto(List.of(1,2,3,4,5,6))));
    }
}
