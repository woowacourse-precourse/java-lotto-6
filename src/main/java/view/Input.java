package view;
import static view.ViewMessage.*;
public class Input {


    public static void inputPrice() {

        System.out.println(ViewMessage.INPUT_PRICE.getMessage());
    }

    public static void inputPrize() {
        System.out.println(TAB.getMessage());
        System.out.println(ViewMessage.INPUT_PRIZE.getMessage());
    }

    public static void inputBonus() {
        System.out.println(TAB.getMessage());
        System.out.println(ViewMessage.INPUT_BONUS.getMessage());
    }
}
