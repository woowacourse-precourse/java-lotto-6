package lotto.model;

public class Bonus {
    private final Integer number;

    public Bonus(String bonusNumber, Lotto winLotto) {

    }

    public Bonus(int number, Lotto winLotto) {


    }

    public boolean matchBonus(Lotto lotto) {

    }

    private int convertStringToInteger(String bonusNumber) {

    }

    public void validate(Integer number, Lotto winLotto) {
        validateIsNull(number);
        validateNumberRange(number);
        validateDuplicatedWinLotto(number, winLotto);
    }

    private void validateIsNull(Integer number) {

    }

    private void validateNumberRange(int number) {
    }

    private void validateDuplicatedWinLotto(Integer number, Lotto lotto) {

    }
}
