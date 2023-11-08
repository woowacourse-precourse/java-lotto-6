package view;

public class Input {
    //input 관련 메세지를 출력하는 view

    private static final String TAB = "";

    public static void inputPrice() {

        System.out.println(ViewMessage.INPUT_PRICE.getMessage());
    }

    public static void inputPrize() {
        System.out.println(TAB);
        System.out.println(ViewMessage.INPUT_PRIZE.getMessage());
    }

    public static void inputBonus() {
        System.out.println(TAB);
        System.out.println(ViewMessage.INPUT_BONUS.getMessage());
    }
}
