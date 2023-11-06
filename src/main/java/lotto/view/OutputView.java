package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottosResponse;
import lotto.message.GameMessage;

public class OutputView {
    public void printBuyMessage(int count){
        System.out.println("\n" + count + GameMessage.BUY_MESSAGE);
    }
    public void printLottos(LottosResponse lottos){
        for (Lotto lotto: lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
