package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LottoCheckerTest {

    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private LottoChecker lottoChecker;


    @DisplayName("Enum결과 생성 함수 반환값 테스트")
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


    @DisplayName("로또 랭크 생성 함수 반환값 테스트 with Mock")
    @Test
    void createLottoRanks_EqualResult_Success() {

        //given
        lottos = mock(Lottos.class);
        winningNumbers = mock(WinningNumbers.class);
        bonusNumber = mock(BonusNumber.class);
        lottoChecker = new LottoChecker(winningNumbers, bonusNumber);
        MockedStatic<LottoRank> lottoRank = mockStatic(LottoRank.class);
        List<Lotto> mockLottos = Arrays.asList(mock(Lotto.class), mock(Lotto.class));

        when(winningNumbers.compareWinningNumbers(anyList())).thenReturn(3L);
        when(bonusNumber.compareBonusNumber(anyList())).thenReturn(true);
        when(lottos.getLottos()).thenReturn(mockLottos);
        lottoRank.when(() -> LottoRank.valueOf(3L, true)).thenReturn(LottoRank.FIFTH);
        //when
        List<LottoRank> result = lottoChecker.createLottoRanks(lottos);

        //then
        assertThat(result.contains(LottoRank.FIFTH)).isTrue();

    }

}