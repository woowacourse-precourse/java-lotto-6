package lotto;

enum Script {
    TOTALPRICE("구입금액을 입력해 주세요."),
    WINNINGNUMBERS("당첨 번호를 입력해 주세요."),
    BONUSNUMBER("보너스 번호를 입력해 주세요.");

    private final String label;

    Script(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
