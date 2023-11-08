package lotto.dto;

import java.util.Map;
import lotto.congin.LottoWinningAmount;

public record WinningStatisticsDto(Map<LottoWinningAmount, Integer> lottoWinningAmount, float yield) {

}
