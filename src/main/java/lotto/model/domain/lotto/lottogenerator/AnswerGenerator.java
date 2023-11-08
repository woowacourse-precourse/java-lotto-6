package lotto.model.domain.lotto.lottogenerator;

import java.util.List;
import lotto.model.domain.lotto.LottoAnswer;

/**
 * 주어진 값들을 이용하여 {@link LottoAnswer}를 생성합니다.
 */
public class AnswerGenerator extends LottoGenerator<LottoAnswer> {
    private static LottoAnswer lottoAnswer;
    private final List<Integer> answerNumbers;
    private final Integer bonusNumber;

    public AnswerGenerator(List<Integer> answerNumbers, Integer bonusNumber) {
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
        lottoAnswer = new LottoAnswer(answerNumbers, bonusNumber);
    }

    @Override
    public LottoAnswer generate() {
        if (lottoAnswer == null) {
            lottoAnswer = new LottoAnswer(this.answerNumbers, this.bonusNumber);
        }
        return lottoAnswer;
    }
}