package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCheckerTest {


    @Test
    void createEnumResult_EqualResult_Success() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 7;
        LottoChecker lottoChecker = new LottoChecker(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));

        LottoRankInfo lottoRankInfo = lottoChecker.createResult(lottos);
        Map<LottoRank, Integer> lottoRank = lottoRankInfo.getLottoRankInfo();
        assertThat(lottoRank.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoRank.size()).isEqualTo(6);


    }

}
