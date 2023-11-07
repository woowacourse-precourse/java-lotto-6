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
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    @DisplayName("Enum 결과 생성 함수 반환값 테스트")
    @Test
    void createEnumResult_EqualResult_Success() {

        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lottos lottos = new Lottos(lottoList);

        //when
        LottoChecker lottoChecker = new LottoChecker(new WinningNumbers(List.of(1, 2, 3, 4, 5, 8)), new BonusNumber(7));
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
        List<Lotto> mockLottos = Arrays.asList(mock(Lotto.class), mock(Lotto.class));
        MockedStatic<LottoRank> lottoRank = mockStatic(LottoRank.class);

        when(winningNumbers.compareWinningNumbers(anyList())).thenReturn(5L);
        when(bonusNumber.compareBonusNumber(anyList())).thenReturn(true);
        when(lottos.getLottos()).thenReturn(mockLottos);
        lottoRank.when(() -> LottoRank.valueOf(5L, true)).thenReturn(LottoRank.SECOND);
        //when
        List<LottoRank> result = lottoChecker.createLottoRanks(lottos);

        //then
        assertThat(result.contains(LottoRank.SECOND)).isTrue();
        lottoRank.close();

    }


}