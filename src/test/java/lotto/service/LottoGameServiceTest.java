package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoGame;
import lotto.domain.ManualLottoGenerator;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.RankPrizeDto;
import lotto.dto.RankResultDto;
import lotto.dto.WinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameServiceTest {

    @DisplayName("로또 게임 서비스를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new LottoGameService(new LottoGame(new ManualLottoGenerator())))
                .doesNotThrowAnyException();
    }

    @DisplayName("구매 금액만큼 로또를 구매한다.")
    @Test
    void purchaseLottosTest() {
        LottoGameService lottoGameService = new LottoGameService(new LottoGame(new ManualLottoGenerator()));
        LottosDto lottosDto = lottoGameService.purchaseLottos(new PurchaseAmountDto(1000));
        List<LottoDto> lottos = lottosDto.lottos();
        assertThat(lottos.size()).isEqualTo(1);
    }

    @DisplayName("당첨 번호를 입력하여 저장한다.")
    @Test
    void determineWinningNumbersTest() {
        LottoGameService lottoGameService = new LottoGameService(new LottoGame(new ManualLottoGenerator()));
        assertThatCode(() -> lottoGameService.determineWinningNumbers(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6))))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호를 입력하여 저장한다.")
    @Test
    void determineBonusNumberTest() {
        LottoGameService lottoGameService = new LottoGameService(new LottoGame(new ManualLottoGenerator()));
        lottoGameService.determineWinningNumbers(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6)));
        assertThatCode(() -> lottoGameService.determineBonusNumber(new BonusNumberDto(7)))
                .doesNotThrowAnyException();
    }

    @DisplayName("구매한 로또와 당첨 번호, 보너스 번호를 비교하여 등수를 산정한다.")
    @Test
    void calculateRankTest() {
        LottoGameService lottoGameService = new LottoGameService(new LottoGame(new ManualLottoGenerator()));
        lottoGameService.purchaseLottos(new PurchaseAmountDto(1000));
        lottoGameService.determineWinningNumbers(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6)));
        lottoGameService.determineBonusNumber(new BonusNumberDto(7));
        RankResultDto rankResultDto = lottoGameService.calculateRank();
        Map<RankPrizeDto, Integer> rank = rankResultDto.rank();
        Integer prizeAmount = rank.entrySet().stream()
                .filter(entry -> entry.getValue().equals(1))
                .findFirst()
                .map(entry -> entry.getKey().prizeAmount())
                .get();
        assertThat(prizeAmount).isEqualTo(2000000000);

        assertThat(rankResultDto.totalReturn()).isEqualTo(200000000.0);
    }
}
