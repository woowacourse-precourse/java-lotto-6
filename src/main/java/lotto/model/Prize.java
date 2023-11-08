package lotto.model;

import java.util.List;
import lotto.utils.Converter;
import lotto.validator.PrizeValidator;
import lotto.view.InputView;

public class Prize {
    private Lotto numbers;
    private int bonusNumber;

    public Prize() {
        setNumbers();
        setBonusNumber();
    }

    private void setNumbers() {
        try {
            numbers = new Lotto(setLottoNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setNumbers();
        }
    }

    private List<Integer> setLottoNumbers() {
        String numbers = InputView.lottoNumbers();
        PrizeValidator.validateNumbers(numbers);
        return Converter.stringToIntegerList(numbers);
    }

    private void setBonusNumber() {
        String number = InputView.bonusNumbers();
        try {
            PrizeValidator.validateBonusNumber(number, numbers);
            bonusNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
