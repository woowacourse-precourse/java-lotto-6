package lotto.view;

import java.util.List;
import lotto.constant.WinPriceMessage;

public class WinPriceView {

    private WinPriceMessage winPriceMessage;

    public void printAllWinPrices(List<Integer> winCounts) {
        for (WinPriceMessage winPrice : WinPriceMessage.values()) {
            int index = winPrice.ordinal();
            String message = formatWinPriceMessage(winPrice, winCounts.get(index));
            System.out.println(message);
        }
    }

    private String formatWinPriceMessage(WinPriceMessage winPriceMessage, int winCount) {
        return String.format("%s (%,d원) - %d개", winPriceMessage.getMessage(),
                winPriceMessage.getPrize(), winCount);
    }


}
