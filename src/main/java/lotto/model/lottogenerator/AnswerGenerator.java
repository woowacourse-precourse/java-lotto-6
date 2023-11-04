package lotto.model.lottogenerator;

import java.util.List;
import java.util.Objects;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoAnswer;

public class AnswerGenerator extends LottoGenerator{
    static LottoAnswer lottoAnswer;
    final List<Integer> list;
    final Integer bonusNumber;

    public AnswerGenerator(List<Integer> list, Integer bonusNumber) {
        this.list = list;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public Lotto generate() {
        if(lottoAnswer == null){
            lottoAnswer = new LottoAnswer(this.list, this.bonusNumber);
        }
        return lottoAnswer;
    }
}
