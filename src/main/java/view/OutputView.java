package view;

import dto.LottoDto;
import dto.WinningResultDto;
import util.message.OutputMessage;

import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottos(final List<LottoDto> lottoDtos, final int numberOfPurchased){
        System.out.println(String.format(OutputMessage.LOTTO_PURCHASE_COUNT.getValue(), numberOfPurchased));
        for (LottoDto lotto : lottoDtos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatics(final WinningResultDto winningResultDto){
        System.out.println(OutputMessage.WINNING_STATICS.getValue());
        System.out.print(winningResultDto.generateResultString());
        System.out.println(OutputMessage.TOTAL_RATE_OF_PROFIT_START.getValue() + winningResultDto.formatRateOfReturn() + OutputMessage.TOTAL_RATE_OF_PROFIT_END.getValue());
    }
}
