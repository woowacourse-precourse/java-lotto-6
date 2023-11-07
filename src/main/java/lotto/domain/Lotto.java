package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateUnique(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            ValidateUtil.isInRange(number, Constant.LOTTO_MINIMUM_NUMBER.getValue(),
                    Constant.LOTTO_MAXIMUM_NUMBER.getValue());
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public static Lotto createLotto(String inputLottoNumbers) {
        List<Integer> lottoNumbers = ValidateUtil.stringToArrayList(inputLottoNumbers);
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto;
    }

    public int createBonusNumber(String inputNumber) {
        int bonusNumber = ValidateUtil.toNumeric(inputNumber);
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        ValidateUtil.isInRange(bonusNumber, Constant.LOTTO_MINIMUM_NUMBER.getValue(),
                Constant.LOTTO_MAXIMUM_NUMBER.getValue());
        if (ValidateUtil.isContain(bonusNumber, numbers)) {
            throw new IllegalArgumentException();
        }

    }

}
