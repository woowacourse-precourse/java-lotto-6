package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(String number) {
//        verification(number);
        this.number = Integer.parseInt(number);
    }

    public boolean bonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }
}