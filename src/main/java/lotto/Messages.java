package lotto;

public class Messages {
    public void priceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void wrongPriceMessage() {
        System.out.println("[ERROR] 천원단위로 입력해주세요");
    }

    public void howManyBuy(int price) {
        price = price / 1000;
        System.out.print(price);
        System.out.println("개를 구매했습니다.");
    }

//    public void numberMessage() {
//        System.out.println("숫");
//    }
}
