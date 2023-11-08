package lotto.model.constants;

public enum StringConstants {
    DELIMITER(","),
    COMMA_WITH_BLANK(", "),
    NEW_LINE("\n"),

    TICKET_CONTENT_START("["),
    TICKET_CONTENT_END("]"),

    RESULT_FORMAT("""
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개"""),
    ;
    private final String message;

    StringConstants(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
