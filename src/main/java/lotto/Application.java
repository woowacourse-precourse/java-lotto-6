package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lottery seller = new Lottery();

        seller.receiveMoney(); // 금액 입력 받기
        seller.calculateQuantityOfLottoAndNotify(); // 발행 가능한 로또 계산 후 알리기

        seller.publishLotto();

    }

}
