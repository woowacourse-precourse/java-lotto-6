package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCheckerTest {


    @Test
    void createEnumResult_EqualResult_Success() {
        LottoChecker lottoChecker = new LottoChecker();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lottos lottos = new Lottos(lottoList);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 7;

        List<LottoRank> lottoRanks = lottoChecker.createEnumMapResult(lottos, winningNumbers, bonusNumber);

        Map<LottoRank, Integer> map = new EnumMap(LottoRank.class);

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            map.put(lottoRank, 0);
        });

        lottoRanks.stream().forEach(lottoRank -> map.put(lottoRank, map.get(lottoRank) + 1));

        assertThat(map.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoRanks.size()).isEqualTo(1);


    }

}
