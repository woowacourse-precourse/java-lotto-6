package View;

import static util.ProgressMessage.OUTPUT_BUY_NUMBER;

import domain.Amount;

public class OuputView {

    public static void buyMessage(Amount amount){
        amount.printAmount();
        System.out.println(OUTPUT_BUY_NUMBER.get());
    }
}
