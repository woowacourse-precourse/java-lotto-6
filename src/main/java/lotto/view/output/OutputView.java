package lotto.view.output;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoRankDto;
import lotto.domain.dto.WinningStatisticsDto;

public interface OutputView {

    void writeAskingBonusNumber();
    void writeAskingCost();
    void writeAskingWinningNumbers();
    void writeLottos(List<LottoDto> lottoDtos);
    void writeWinningStatistics(WinningStatisticsDto winningStatisticsDto, LottoRankDto lottoRankDto);
    }

}
