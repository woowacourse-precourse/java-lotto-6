package lotto.view;

public enum Notice {

    NOTICE_PURCHASE_PRICE("구입금액을 입력해 주세요. 구입금액은 1,000원 단위로 입력가능합니다.(e.g. 3000)"),
    NOTICE_LOTTO_NUMBERS("당첨 번호를 입력해주세요. 로또 번호는 1~45 범위의 중복되지 않은 6개 숫자입니다."),
    NOTICE_BONUS_NUMBERS("보너스 번호를 입력해주세요. 보너스 번호는 1~45 범위의 당첨번호와 중복되지 않은 1개 숫자입니다."),
    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}
