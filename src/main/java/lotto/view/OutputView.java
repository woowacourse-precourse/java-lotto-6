package lotto.view;

public class OutputView {
    public static void askAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void calculateLottoCount(){
        int LottoCount = InputView.getLottoPrice()/1000;
        System.out.println(LottoCount+"개를 구매했습니다.");
    }
}
