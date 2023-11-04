package lotto.view;

import java.util.List;
import lotto.message.GameMessage;

public class OutputView {
    public void printBuyMessage(int count){
        System.out.println("\n" + count + GameMessage.BUY_MESSAGE);
    }
    public void printLottos(List<Integer> lotto){
        System.out.println(lotto);
    }
}
