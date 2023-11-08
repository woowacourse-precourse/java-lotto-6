package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.constant.Constable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoService.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MethodTest {

    @DisplayName("구매금액을 입력하면 구매한 로또 갯수가 출력된다.")
    @Test
    void setBoughtTest() {
        int paid = 8000;
        int expect = paid / 1000;

        LottoService lottoService = new LottoService();

        assertThat(lottoService.setBought(paid)).isEqualTo(expect);
    }

    @DisplayName("로또 갯수를 입력하면 그 갯수만큼 로또가 오름차순 정렬되어 출력된다.")
    @Test
    void createLottoNumsTest() {
        int bought = 6;

        LottoService lottoService = new LottoService();

        Lotto[] lottos = lottoService.createLottoNums(bought);

        assertThat(lottos.length).isEqualTo(bought);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers())
                    .isSortedAccordingTo(Comparator.comparing(Integer::intValue));
        }
    }

    @DisplayName("로또 정보를 입력하면 값을 대조하여 로또 결과가 저장된다.")
    @Test
    void setResultTest() {
        Lotto[] lottoNum = new Lotto[5];

        lottoNum[0] = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoNum[1] = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        lottoNum[2] = new Lotto(List.of(1, 2, 3, 4, 8, 10));
        lottoNum[3] = new Lotto(List.of(2, 3, 5, 10, 20, 33));
        lottoNum[4] = new Lotto(List.of(5, 6, 10, 20, 35, 41));

        Lotto userNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;
        int[] resultCompared = {1, 1, 0, 1, 1};

        LottoService lottoService = new LottoService();

        lottoService.setResult(lottoNum, userNum, bonusNum);

        assertThat(lottoWinsCount).isEqualTo(resultCompared);
    }

    @DisplayName("로또 결과에 따른 수익금이 출력된다.")
    @Test
    void getEarnedTest() {
        long earnCompared = 0;

        LottoService lottoService = new LottoService();
        lottoWinsCount[0] = 1;
        lottoWinsCount[1] = 1;
        lottoWinsCount[2] = 0;
        lottoWinsCount[3] = 0;
        lottoWinsCount[4] = 2;

        for (Rank rank : Rank.values()) {
            earnCompared += (long) rank.getPrize() * lottoWinsCount[rank.ordinal()];
        }

        long earned = lottoService.getEarned();

        assertThat(earned).isEqualTo(earnCompared);
    }
}
