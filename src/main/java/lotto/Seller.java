package lotto;

public class Seller {
    public int count;
    public Seller() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 입력한 가격에 대한 구매 수량 출력
    public void checkByPurchaseCount(Customer customer) {
        count = customer.getPrice()/1000;
        System.out.println("");
        System.out.println( count +"개를 구매했습니다.");
    }

}
