package lotto.model.domain.lotto.lottogenerator;

import java.util.List;
import lotto.model.domain.lotto.LottoAnswer;

public class AnswerGenerator extends LottoGenerator<LottoAnswer> {
    private static LottoAnswer lottoAnswer;
    private final List<Integer> list;
    private final Integer bonusNumber;

    public AnswerGenerator(List<Integer> list, Integer bonusNumber) {
        this.list = list;
        this.bonusNumber = bonusNumber;
        lottoAnswer = new LottoAnswer(list, bonusNumber);
    }

    @Override
    public LottoAnswer generate() {
        if (lottoAnswer == null) {
            lottoAnswer = new LottoAnswer(this.list, this.bonusNumber);
        }
        return lottoAnswer;
    }
}