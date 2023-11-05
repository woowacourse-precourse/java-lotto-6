package lotto.model.domain;

import java.util.Collections;
import java.util.List;
import lotto.constance.GameConst;
import lotto.constance.PrintConst;
import lotto.model.domain.result.CompareResult;
import lotto.util.LottoGameException;

public class Lotto {
    private static final int LOTTO_SIZE = GameConst.LOTTO_SIZE;

    //수정 금지
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumbersNotDuplicated(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        long wrongNumberCount = numbers.stream()
                .filter(number -> number > GameConst.LOTTO_RANGE_END ||
                        number < GameConst.LOTTO_RANGE_START)
                .count();
        if(wrongNumberCount != 0){
            throw LottoGameException.WRONG_LOTTO_RANGE.makeException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    private void validateNumbersNotDuplicated(List<Integer> numbers) {
        int distinctNum = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctNum != LOTTO_SIZE){
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
        }
    }

    @Override
    public String toString() {
        return String.format(PrintConst.FORMAT_LOTTO_NUMBERS, this.numbers.toArray());
    }

    public CompareResult compareLotto(Lotto lotto){
        int collectNumber = collectNumber(lotto);
        if(isCompareFinish(lotto, collectNumber)){
            return new CompareResult(collectNumber, false);
        }
        boolean collectBonus = isCollectBonus((LottoAnswer) lotto);
        return new CompareResult(collectNumber, collectBonus);
    }

    private boolean isCompareFinish(Lotto lotto, int collectNumber) {
        return lotto.getClass() != LottoAnswer.class ||
                collectNumber != GameConst.BONUS_CHECH_NECESSARY;
    }

    private int collectNumber(Lotto lotto){
        return (int) lotto.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }

    private boolean isCollectBonus(LottoAnswer answer){
        int bonusNumber = answer.getBonusNumber();
        return this.numbers.contains(bonusNumber);
    }
}
