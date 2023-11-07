package lotto.common;

public enum Announcement {

    INPUT_AMOUNT("구입금액을 입력해 주세요.\n")
    ;

    private String script;

    Announcement(String script) {
        this.script = script;
    }

    public void speak() {
        System.out.print(this.script);
    }

}
