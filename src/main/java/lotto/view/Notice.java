package lotto.view;

public enum Notice {

    NOTICE_PURCHASE_PRICE("구입금액을 입력해 주세요. 구입금액은 1,000원 단위로 입력가능합니다.(e.g. 3000)"),

    ;

    private final String notice;

    Notice(final String notice) {
        this.notice = notice;
    }

    public void print() {
        System.out.println(notice);
    }
}
