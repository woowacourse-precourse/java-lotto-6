package lotto.view;

public class MessageDisplay {
    public static void enterBuyingPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public static void writeBuyingPrice(int buyingPrice) {
        System.out.println(buyingPrice + "개를 구매했습니다.");
    }
    public static void enterWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
