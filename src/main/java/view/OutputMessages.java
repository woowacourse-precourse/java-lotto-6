package view;

public enum OutputMessages {
    TOTAL_PURCHASED_QUANTITY("\n%d개를 구매했습니다.");

    private String message;

    private OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
