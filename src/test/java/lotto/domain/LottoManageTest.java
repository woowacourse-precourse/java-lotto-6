package lotto.domain;

import lotto.global.utils.generator.IntendedNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoManageTest {

    @DisplayName("InputLotto와 RandomLotto의 일치하는 개수를 출력한다.")
    @Test
    void should_returnLottoCount_when_InputLottoAndRandomLotto() {
//      given
        RandomLottoList randomLottoList = new RandomLottoList(new IntendedNumberGenerator(Arrays.asList(1,2,3,7,5,6)));

        Lotto inputLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        BonusNumber bonusNumber = new BonusNumber(inputLotto, 7);

//      when
        LottoManage lottoManage = new LottoManage();
        lottoManage.getWinningCount(inputLotto, bonusNumber, randomLottoList);

        int correctCount = lottoManage.getCorrectCount();
        int correctBonusCount = lottoManage.getCorrectBonusCount();

//      then
        assertEquals(5, correctCount);
        assertEquals(1, correctBonusCount);

    }
}