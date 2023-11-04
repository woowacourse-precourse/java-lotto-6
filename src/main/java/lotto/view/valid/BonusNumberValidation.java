package lotto.view.valid;

public class BonusNumberValidation implements InputValidation<Integer> {

    @Override
    public Integer validateInput(final String bonusNumberText, final ViewValidator viewValidator) {
        return viewValidator.parseInt(bonusNumberText);
    }
}
