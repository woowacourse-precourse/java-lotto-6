package lotto.model.lottogenerator;

import java.util.List;
import java.util.Objects;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoAnswer;

public class AnswerGenerator extends LottoGenerator{
    private static LottoAnswer lottoAnswer;
    private final List<Integer> list;
    private final Integer bonusNumber;

    public AnswerGenerator(List<Integer> list, Integer bonusNumber) {
        this.list = list;
        this.bonusNumber = bonusNumber;
        lottoAnswer = new LottoAnswer(list, bonusNumber);
    }

    @Override
    public Lotto generate() {
        if(lottoAnswer == null){
            lottoAnswer = new LottoAnswer(this.list, this.bonusNumber);
        }
        return lottoAnswer;
    }
}
