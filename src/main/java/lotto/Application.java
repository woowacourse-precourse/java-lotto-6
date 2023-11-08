package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lottery seller = new Lottery();

        seller.receiveMoney(); // 금액 입력 받기

        System.out.println();
        seller.calculateQuantityOfLottoAndNotify(); // 발행 가능한 로또 계산 후 알리기
        seller.publishLotto(); // 로또 발행하기

        System.out.println();
        seller.getChosenLottoNumber(); // 당첨된 로또 번호 받기

        System.out.println();
        seller.getChosenBonusNumber(); // 보너스 번호 입력

        System.out.println();
        seller.notifyLottoResult();
    }

}
