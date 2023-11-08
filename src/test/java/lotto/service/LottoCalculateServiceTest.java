package lotto.service;

import static lotto.util.TestUtil.getLottoCompareTestSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import lotto.dto.LottosCalculateResult;
import lotto.exception.NonVariableException;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoRank;
import lotto.model.LottoWallet;
import lotto.model.LottoWinningNumbers;
import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculateServiceTest extends NsTest {

    LottoCalculateService lottoCalculateService;
    UserLottoRepository userLottoRepository;
    LottoWinningRepository lottoWinningRepository;

    @BeforeEach
    void setup() {
        this.userLottoRepository = new UserLottoRepository();
        this.lottoWinningRepository = new LottoWinningRepository();
        this.lottoCalculateService = new LottoCalculateService(userLottoRepository, lottoWinningRepository);
    }

    void winningRepositorySetup() {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        lottoWinningRepository.saveLottoWinningNumbers(winningNumbers);
        lottoWinningRepository.saveLottoBonusNumber(new LottoBonusNumber(winningNumbers, "7"));
    }

    @DisplayName("1등 로또 번호가 저장된다.")
    @Test
    void successSaveRecentWinningNumbers() throws NoSuchFieldException, IllegalAccessException {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        LottoBonusNumber bonusNumber = new LottoBonusNumber(winningNumbers, "7");

        // when
        lottoCalculateService.saveRecentWinningNumbers(winningNumbers, bonusNumber);

        // then
        assertThat(lottoWinningRepository.getLottoWinningNumbers())
                .isEqualTo(winningNumbers);
        assertThat(lottoWinningRepository.getLottoBonusNumber())
                .isEqualTo(bonusNumber);
    }

    @DisplayName("필요한 데이터가 없으면 예외가 발생한다.")
    @Test
    void readyCheckThrow() throws NoSuchMethodException {
        Method method = getAccessibleMethod("readyCheck");

        assertThatThrownBy(() -> method.invoke(lottoCalculateService))
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(NonVariableException.class);
    }

    @DisplayName("로또 1등만 증가한다.")
    @Test
    void increaseRankFor1St() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Method method = getAccessibleMethod("increaseRank", Map.class, LottoRank.class);
        Map<LottoRank, Integer> ranks = LottoRank.createRankMap();

        // when
        method.invoke(lottoCalculateService, ranks, LottoRank.RANK_1ST);

        // then
        int rankValue = ranks.get(LottoRank.RANK_1ST);
        assertThat(rankValue).isEqualTo(1);
    }

    @DisplayName("로또 등수를 가져온다.")
    @Test
    void successLottoCompare() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        LottoBonusNumber bonusNumber = new LottoBonusNumber(winningNumbers, "7");
        Method method = getAccessibleMethod("lottoCompare", LottoWinningNumbers.class, LottoBonusNumber.class,
                Lotto.class);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        LottoRank value = (LottoRank) method.invoke(lottoCalculateService, winningNumbers, bonusNumber, lotto);

        // then
        assertThat(value).isEqualTo(LottoRank.RANK_1ST);
    }

    @DisplayName("로또 2등 당첨 확인")
    @Test
    void successRunAllCompare()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        winningRepositorySetup();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoWallet wallet = new LottoWallet(List.of(new Lotto[]{
                lotto
        }));
        userLottoRepository.saveLottoWallet(wallet);
        Method method = getAccessibleMethod("runAllCompare");

        // when
        Map<LottoRank, Integer> result = (Map<LottoRank, Integer>) method.invoke(lottoCalculateService);

        // then
        int rankValue = result.get(LottoRank.RANK_2ND);
        assertThat(rankValue).isEqualTo(1);
    }

    @DisplayName("수익률을 가져온다.")
    @Test
    void successRateOfReturnCalculation()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Method method = getAccessibleMethod("rateOfReturnCalculation", Map.class);
        Map<LottoRank, Integer> ranks = getLottoCompareTestSet();

        // when
        double result = (double) method.invoke(lottoCalculateService, ranks);

        // then
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("통계 정보를 잘 가지고 온다.")
    @Test
    void successWinningStatistics() {
        // given
        winningRepositorySetup();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoWallet wallet = new LottoWallet(List.of(new Lotto[]{
                lotto
        }));
        userLottoRepository.saveLottoWallet(wallet);

        // when
        LottosCalculateResult dto = lottoCalculateService.winningStatistics();

        // then
        assertThat(dto.getMatches()).isNotNull();
        assertThat(dto.getRateOfReturn()).isNotNull();
    }

    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = lottoCalculateService.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}