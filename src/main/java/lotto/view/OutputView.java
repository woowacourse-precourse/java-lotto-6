package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.WinningCountDto;
import lotto.utility.enums.Messages;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {
    private OutputView(){}; //생성자로 인스턴스 생성 막기

    public static void printLottoCount(int lottoCount){
        System.out.println(String.format(Messages.LOTTO_COUNT_MESSAGE.getMessage(),lottoCount));
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers.toString());
    }

    public static void printLottosResult(WinningCountDto winningCountDto){
        System.out.println(Messages.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(String.format(Messages.THREE_WINNING_MESSAGE.getMessage(),winningCountDto.getMatchThreeWinningCount()));
        System.out.println(String.format(Messages.FOUR_WINNING_MESSAGE.getMessage(),winningCountDto.getMatchFourWinningCount()));
        System.out.println(String.format(Messages.FIVE_WINNING_MESSAGE.getMessage(),winningCountDto.getMatchFiveWinningCount()));
        System.out.println(String.format(Messages.FIVE_WINNING_AND_BONUS_MESSAGE.getMessage(),winningCountDto.getMatchFiveWinningAndBonusCount()));
        System.out.println(String.format(Messages.SIX_WINNING_MESSAGE.getMessage(),winningCountDto.getMatchSixWinningCount()));
    }

    public static void printLottoProfitRate(BigDecimal profitRate){
        System.out.print(String.format(Messages.LOTTO_PROFIT_RATE_MESSAGE.getMessage(),profitRate.toString()));
    }

}
