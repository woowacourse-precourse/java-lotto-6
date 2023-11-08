package lotto.validator;

import java.util.List;

public class LottoValidator {

    private final List<Integer> lottoList;

    public LottoValidator(List<Integer> lottoList) {
        this.lottoList = lottoList;
    }

    public void validateAll() {
        validateSize();
        validateNumberRange();
        validateUnique();
    }

    private void validateSize() {
        if (lottoList.size() != 6) {
            throw new IllegalArgumentException("로또는 6개여야 합니다.");
        }
    }

    private void validateUnique() {
        if (hasDuplicateNumber()){
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicateNumber() {
        return lottoList.stream()
                .distinct()
                .count() != 6;
    }

    private void validateNumberRange() {
        lottoList.stream()
                .filter(this::isNumberWrongRange)
                .forEach(number -> {
                    throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 가능합니다.");
                });
    }

    public void validateBonusNumber(int bonusNumber) {
        if (isNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 가능합니다.");
        }

        if (lottoList.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    private boolean isNumberWrongRange(int lotto) {
        return (lotto < 1 || lotto > 45);
    }

}
