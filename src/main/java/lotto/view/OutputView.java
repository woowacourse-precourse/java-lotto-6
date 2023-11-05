package lotto.view;

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

    public static void  responseLottoNumber(int count){
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Lotto.randomNumber(6);
            Collections.sort(randomNumbers);
            System.out.println(randomNumbers);
        }
    }


}