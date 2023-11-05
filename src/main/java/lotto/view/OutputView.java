package lotto.view;

public enum OutputView {
    // Request
    ASK_INPUT_MONEY("구입금액을 입력해 주세요."),
    ASK_INPUT_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_INPUT_BONUS("보너스 번호를 입력해 주세요."),

    PURCHASE_RESULT("%d 개를 구매했습니다."),
    RETURN_RESULT("총 수익률은 %d 입니다.");

    public void resultLotto() {
        System.out.println("3개 일치 (5,000원) - %d 개");
        System.out.println("4개 일치 (50,000원) - %d 개");
        System.out.println("5개 일치 (1,500,000원) - %d 개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - %d 개");
        System.out.println("6개 일치 (2,000,000,000원) - %d 개");
    }

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
