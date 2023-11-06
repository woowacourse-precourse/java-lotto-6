package lotto;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoGame;
import lotto.model.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("당첨과 로또의 일치 정도 판단")
    void MakePrizeResultIfLottoAndAnswerInput() {
        final List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LottoGame lottogame = new LottoGame(10000);
        lottogame.createLotto();
        Prize prize = new Prize();
        Map<Integer, Integer> prizeResult = prize.getPrizeResult();
        int sum = 0;

        prize.compareAnswerAndLotto(answer, lottogame);
        for (int i = 0; i < prizeResult.size(); i++) {
            sum += prizeResult.get(i);
        }

        if (sum != lottogame.getLottoNumber()) {
            fail();
        }

    }

