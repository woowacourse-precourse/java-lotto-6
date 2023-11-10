package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    LottoGame lottoGame = new LottoGame();
    @Test
    void compareLottoIndexTest(){
        List<Integer> fakeWinningNumbers = Arrays.asList(1,2,4,6,8,10);
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

    }

}