package lotto;

public class Application {
    public static void main(String[] args) {

        Price price = new Price(); //로또 구입 금액 객체
        int ticket = 0; //로또 몇 장 사는지 저장하는 변수

        System.out.println("구입금액을 입력해 주세요.");
        price.inputPrice();

        ticket = price.getTicket();
    }
}
