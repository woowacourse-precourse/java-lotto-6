package lotto.view;

public enum Status {
    GOT_NOTHING(false),
    GOT_ERROR(false),
    GOT_MESSAGE(true);

    private final boolean status;

    Status(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
