package lotto.view;

public class OutputView {
    public static void askAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void calculateLottoCount(){
        final int LOTTO_COUNT = InputView.LOTTO_PRICE/1000;
        System.out.println(LOTTO_COUNT+"개를 구매했습니다.");
    }
}
