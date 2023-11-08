package lotto.view;

public enum LottoResultConstants {
    BASIC_RESULT_FORMAT("%d개 일치 (%,d원) - %d개\n"),
    SECOND_RESULT_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    BENEFIT_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String text;

    LottoResultConstants(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
