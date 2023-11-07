package lotto.handler;

import static lotto.message.SystemMessage.*;
import static lotto.util.OutputUtil.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.OutputView;

public class OutputHandler {
    public static void outputLottosInfo(List<Lotto> lottos){
        OutputView.printMessageBlankLine();
        printLottosAmount(lottos);
        OutputView.printMessagesWithBlankLine(lottos);
    }

    public static void outputWinningNums(List<Integer> winnerNums){
        OutputView.printMessage(OUTPUT_WINNING_NUMBERS);
        OutputView.printWithBlankLine(formatNumsToString(winnerNums));
    }
    public static void outputBonusNumber(int bonusNum){
        OutputView.printMessage(OUTPUT_BONUS_NUMBER);
        OutputView.printWithBlankLine(bonusNum);
    }

    private static void printLottosAmount(List<Lotto> lottos) {
        OutputView.print(formatSystemMessageWithNumber(OUTPUT_PURCHASE_LOTTO_AMOUNT, lottos.size()));
    }
}
