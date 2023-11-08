package lotto.view;

import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.enums.ErrorMessage;
import lotto.enums.OutputMessage;
import lotto.model.Lotto;

public class OutputView {
    public static void printLottoCountBought(Integer lottoCount) {
        System.out.println(String.format(
                OutputMessage.NUMBER_OF_PURCHASED_LOTTO.getMessage(),
                lottoCount
        ));
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(String.format(
                OutputMessage.LOTTO_NUMBERS.getMessage(),
                lotto
        ));
    }

    public static void printResultOfLottery(WinningStatisticDTO winningStatisticDTO) {
        System.out.println(String.format(
                OutputMessage.RESULT_OF_LOTTERY.getMessage(),
                winningStatisticDTO.getMatched3(),
                winningStatisticDTO.getMatched4(),
                winningStatisticDTO.getMatched5(),
                winningStatisticDTO.getMatched5AndBonusNumber(),
                winningStatisticDTO.getMatched6()
        ));
    }

    public static void printReturnRate(MoneyDTO moneyDTO) {
        System.out.println(String.format(
                OutputMessage.RETURN_RATE.getMessage(),
                moneyDTO.getReturnRate()
        ));
    }

    public static void printError(String errorMessage) {
        System.out.println(String.format(
                ErrorMessage.FORMAT.getMessage(),
                errorMessage
        ));
    }

    public static void printLineFeed() {
        System.out.println();
    }
}
