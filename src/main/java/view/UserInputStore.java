package view;

import camp.nextstep.edu.missionutils.Console;
import error.InputError;

public class UserInputStore {
    private static int purchsePrice = 0;

    public static int lottoPurchase(){
        lottoPurchaseInput();
        InputError.notDivisible(purchsePrice);
        return purchsePrice;
    }

    private static int lottoPurchaseInput(){
        String price = Console.readLine();
        purchsePrice =Integer.parseInt(price);
        return purchsePrice;
    }

    public static int getLottoPurchase(){
        return purchsePrice;
    }
}
