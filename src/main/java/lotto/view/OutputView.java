package lotto.view;

import java.util.List;
import lotto.constant.PrintMessage;

public class OutputView {
    public void inputPriceNoticeOutput() {
        System.out.println(PrintMessage.INPUT_PRICE.getMessage());
    }

    public void boughtLottoOutput(int number, List<String> boughtLottos) {
        String boughtNumber = String.valueOf(number);
        System.out.println(boughtNumber.concat(PrintMessage.BOUGHT_LOTTO_NUMBERS.getMessage()));
        for (String s : boughtLottos) {
            System.out.println(s);
        }
    }

    public void inputWinLottoNumberNoticeOutput() {
        System.out.println(PrintMessage.INPUT_WIN_LOTTO_NUMBERS.getMessage());
    }

    public void inputBonusNumberNoticeOutput() {
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void statisticsOutput(List<String> result) {
        System.out.println(PrintMessage.WINNING_STATISTICS.getMessage());
        System.out.println(PrintMessage.LINE.getMessage());
        for (String s : result) {
            System.out.println(s);
        }
    }

    public void earningRateOutput(String earningRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(PrintMessage.EARNING_RATE_FRONT.getMessage());
        sb.append(earningRate);
        sb.append(PrintMessage.EARNING_RATE_BACK.getMessage());
        System.out.println(sb);
    }
}
