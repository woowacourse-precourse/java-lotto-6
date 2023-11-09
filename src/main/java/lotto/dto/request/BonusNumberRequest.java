package lotto.dto.request;

public class BonusNumberRequest {

    private final String bonusNumber;

    public BonusNumberRequest(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
