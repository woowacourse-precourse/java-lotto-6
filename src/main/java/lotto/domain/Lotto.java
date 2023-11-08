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
            throw new IllegalArgumentException("[Error] 6자리의 수를 입력 하세요");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 겹치지 않는 번호를 입력하세요");
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
        return new Lotto(lottoNumbers);
    }

    public int createBonusNumber(String inputNumber) {
        int bonusNumber = ValidateUtil.toNumeric(inputNumber);
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        ValidateUtil.isInRange(bonusNumber, Constant.LOTTO_MINIMUM_NUMBER.getValue(),
                Constant.LOTTO_MAXIMUM_NUMBER.getValue());
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 이미 포함되어 있습니다.");
        }
    }

    public LottoRecord winCheck(Lotto winLotto, int bonusNumber) {
        int matchCount = (int) numbers.stream().filter(winLotto.getLottoNumbers()::contains).count();
        boolean isBonusMatched = numbers.contains(bonusNumber);
        return new LottoRecord(matchCount, isBonusMatched);
    }


}
