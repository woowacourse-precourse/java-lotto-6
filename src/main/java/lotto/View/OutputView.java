package lotto.View;

import lotto.View.Constants.ErrorMessage;
import lotto.View.Constants.InfoMessage;
import lotto.View.Constants.WinningMessage;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final int ALL_PRIZE_CASE = 5;

    ErrorMessage[] err = ErrorMessage.values();
    InfoMessage[] info = InfoMessage.values();
    WinningMessage[] win = WinningMessage.values();

    public void profitPercentOutput (double profitPercent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String output = decimalFormat.format(profitPercent);
        System.out.println(WinningMessage.ROI.formOutput(output));
    }

    public void corrects (List<Integer> winning, WinningMessage[] winningMessages){
        for (int i = 0; i < ALL_PRIZE_CASE ; i++) {
            System.out.println(winningMessages[i].formMessage(winning.get(i)));
        }
        System.out.println();
    }
}
