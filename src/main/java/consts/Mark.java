package consts;

public enum Mark {

    INPUT_SEPARATOR(","),
    OUTPUT_JOINER(", "),
    AMOUNT_SEPARATOR(","),
    AMOUNT_REGEX("\\B(?=(\\d{3})+(?!\\d))");

    private final String mark;

    Mark(final String mark) {
        this.mark = mark;
    }

    public String mark() {
        return mark;
    }
}
