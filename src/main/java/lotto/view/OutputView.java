package lotto.view;

import java.util.List;
import lotto.constant.PrintMessage;

public class OutputView {
    public void inputPriceNoticeOutput() {
        System.out.println(PrintMessage.INPUT_PRICE);
    }

    public void boughtLottoOutput(int number, List<String> boughtLottos) {
        String boughtNumber = String.valueOf(number);
        System.out.println(boughtNumber.concat(PrintMessage.BOUGHT_LOTTO_NUMBERS));
        for (String s : boughtLottos) {
            System.out.println(s);
        }
    }

    public void inputWinLottoNumberNoticeOutput() {
        System.out.println(PrintMessage.INPUT_WIN_LOTTO_NUMBERS);
    }

    public void inputBonusNumberNoticeOutput() {
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER);
    }

    public void statisticsOutput(List<String> result) {
        System.out.println(PrintMessage.WINNING_STATISTICS);
        System.out.println(PrintMessage.LINE);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public void earningRateOutput(String earningRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(PrintMessage.EARNING_RATE_FRONT);
        sb.append(earningRate);
        sb.append(PrintMessage.EARNING_RATE_BACK);
        System.out.println(sb);
    }
}
