package lotto.view;

import java.util.List;
import lotto.message.GameMessage;

public class OutputView {
    public void printBuyMessage(int count){
        System.out.println();
        System.out.println(count + GameMessage.BUY_MESSAGE);
    }
    public void printLottos(List<Integer> lotto){
        System.out.println(lotto);
    }
}
