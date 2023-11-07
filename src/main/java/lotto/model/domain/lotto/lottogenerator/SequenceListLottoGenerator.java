package lotto.model.domain.lotto.lottogenerator;

import java.util.LinkedList;
import java.util.List;
import lotto.constance.GameConst;
import lotto.exception.LottoGameException;
import lotto.model.domain.lotto.Lotto;

public class SequenceListLottoGenerator extends LottoGenerator {
    List<List<Integer>> numbersSequence;

    public SequenceListLottoGenerator(List<List<Integer>> numbersSequence) {
        numbersSequence.stream()
                .forEach(this::valdateNumbers);
        this.numbersSequence = new LinkedList<>(numbersSequence);
    }

    private void valdateNumbers(List<Integer> numbers) {
        if (numbers.size() != GameConst.LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
        if (numbers.stream().distinct().count() != GameConst.LOTTO_SIZE) {
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
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
