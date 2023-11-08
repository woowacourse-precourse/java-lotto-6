package lotto.view;

public enum Status {
    GOT_NOTHING(true),
    GOT_ERROR(true),
    GOT_MESSAGE(false);

    private final boolean status;

    Status(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
