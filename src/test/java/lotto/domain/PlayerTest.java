package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @DisplayName("사용자의 로또 결과를 리스트로 반환한다.")
    @Test
    void testLottoTicketCheckAndResults() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(pickUniqueNumbersInRange(1, 45, 6)),
                new Lotto(pickUniqueNumbersInRange(1, 45, 6))
        );
        player = new Player(lottoList);
        WinningNumber winLotto = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        List<LottoRank> lottoRanks = player.checkLottoTickets(winLotto);
        Assertions.assertEquals(lottoRanks.size(), 3);
    }


}