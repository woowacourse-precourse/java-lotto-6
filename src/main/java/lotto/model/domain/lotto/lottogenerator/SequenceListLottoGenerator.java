package lotto.model.domain.lotto.lottogenerator;

import java.util.LinkedList;
import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.lotto.Lotto;

/**
 * 주어진 List 값을 사용해 {@link Lotto}를 생성합니다.
 * <p>
 * LottoGenerator 생성시 List 형식의 숫자 리스트를 받습니다. 숫자 리스트를 순서대로 사용하여 로또를 생성합니다. 숫자 리스트를 전부 사용했다면 마지막에 사용한 숫자 리스트를 반복하여
 * 재사용합니다.
 * </p>
 */
public class SequenceListLottoGenerator extends LottoGenerator<Lotto> {
    private final List<List<Integer>> numbersSequence;

    public SequenceListLottoGenerator(List<List<Integer>> numbersSequence) {
        numbersSequence.forEach(this::validateNumbers);
        this.numbersSequence = new LinkedList<>(numbersSequence);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        int distinctCount = (int) numbers.stream().distinct().count();
        return distinctCount != GameConst.LOTTO_SIZE;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != GameConst.LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    @Override
    public Lotto generate() {
        if (this.numbersSequence.size() == 1) {
            return new Lotto(this.numbersSequence.get(0));
        }
        return new Lotto(this.numbersSequence.remove(0));
    }
}
