package lotto.view.service;

import lotto.lotto.dto.LottoDto;
import lotto.statistic.dto.ResultDto;

import java.util.List;

public interface ViewOutputService {

    void printPurchasedCount(List<LottoDto> lottoDtos);

    void printTotalStatistics(ResultDto resultDto);
}
