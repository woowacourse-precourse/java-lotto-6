package lotto.dto.request;

public class BonusNumberRequest {
    private final int number;

    public BonusNumberRequest(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
