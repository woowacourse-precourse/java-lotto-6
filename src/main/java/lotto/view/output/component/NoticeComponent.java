package lotto.view.output.component;

public class NoticeComponent {
    private final String NOTICE_BONUS_NUMBER = "보너스 번호를 입력해주세요";
    private final String NOTICE_NUMBERS = "당첨번호를 입력해주세요";
    private final String NOTICE_PURCHASE_PRICE = "구입금액을 입력해 주세요.";


    public void askPurchasePrice() {
        System.out.println(NOTICE_PURCHASE_PRICE);
    }

    public void askLottoNumbers() {
        System.out.println();
        System.out.println(NOTICE_NUMBERS);
    }

    public void askLottoBonusNumber() {
        System.out.println();
        System.out.println(NOTICE_BONUS_NUMBER);
    }
}
