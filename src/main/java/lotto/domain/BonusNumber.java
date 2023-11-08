package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto ticket) {
        validate(bonusNumber, ticket);
        this.bonusNumber = bonusNumber;
    }

    void validate(int bonusNumber, Lotto ticket) {
        if (ticket.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("번호가 중복.");
        }
    }

    public boolean isMatch(Lotto ticket) {
        return ticket.getLottoNumbers().contains(bonusNumber);
    }
}