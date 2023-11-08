package lotto.statistic.service;

import lotto.constant.Prize;
import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;

import java.util.List;

public interface StatisticService {

    void create(List<LottoDto> lottoDtos, List<Integer> winningNumbers, int bonusNumber);

    int compareToWinningNumbers(LottoDto lottoDto, List<Integer> winningNumbers);

    boolean compareToBonusNumber(LottoDto lottoDto, int bonusNumber);

    Prize calculateRank(int hitWinningNumbersCount, boolean hitBonusNumberCount);

    ResultDto getResult(int purchaseAmount);
}
