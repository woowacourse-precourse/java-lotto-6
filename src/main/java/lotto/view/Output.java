package lotto.view;

import lotto.constants.OutputMessage;
import lotto.domain.Lotto;

import java.util.ArrayList;

public class Output {
    public void printLotteryNumber(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size() + OutputMessage.PRINT_BUY_LOTTO_SIZE.getOutputMessage());
        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
