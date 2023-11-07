package lotto.common;

public enum Announcement {

    INPUT_AMOUNT("구입금액을 입력해 주세요.\n"),
    PURCHASE_LOTTOS("개를 구매했습니다.\n")
    ;

    private final String script;

    Announcement(String script) {
        this.script = script;
    }

    public void speak() {
        System.out.print(this.script);
    }

    public void speak(int size) {
        System.out.print(size + this.script);
    }
}
