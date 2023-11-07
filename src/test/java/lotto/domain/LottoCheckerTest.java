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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCheckerTest {

    @DisplayName("Enum결과 생성 함수 성공 테스트")
    @Test
    void createEnumResult_EqualResult_Success() {

        //given
        List<Lotto> lottoList = new ArrayList<>();
        Lottos lottos = new Lottos(lottoList);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 7;
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when
        LottoChecker lottoChecker = new LottoChecker(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));
        LottoRankInfo lottoRankInfo = lottoChecker.createResult(lottos);
        Map<LottoRank, Integer> lottoRank = lottoRankInfo.getLottoRankInfo();

        //then
        assertThat(lottoRank.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoRank.size()).isEqualTo(6);

    }


}
