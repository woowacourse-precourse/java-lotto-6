package View;

import static util.ProgressMessage.OUTPUT_BUY_NUMBER;

import domain.Amount;
import domain.Lottos;

public class OuputView {

    public static void buyMessage(Amount amount) {
        amount.printAmount();
        System.out.println(OUTPUT_BUY_NUMBER.get());
    }

    public static void lottosNumbers(Lottos lottos) {
        System.out.println(lottos);
    }
}
