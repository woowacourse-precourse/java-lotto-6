package lotto.view;

import static lotto.domain.PurchaseAmount.count;
import static lotto.view.constans.constantMessage.PURCHASED_TICKET_COUNT;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constans.constantMessage;

public class OutputView {

    public static void printConstantMessage(constantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static void responseCount(int count){
        System.out.print(count);
        printConstantMessage(PURCHASED_TICKET_COUNT);
    }

    public static void responseLottoNumber(List<Integer> lotto){
            System.out.println(lotto);

    }


}