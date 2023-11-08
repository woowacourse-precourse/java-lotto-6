package lotto.model.constants;

public enum StringConstants {
    DELIMITER(","),
    COMMA_WITH_BLANK(", "),
    TICKET_CONTENT_START("["),
    TICKET_CONTENT_END("]")
    ;
    private final String message;

    StringConstants(String message) {
        this.message = message;
    }

    public String get(){
        return message;
    }
}
