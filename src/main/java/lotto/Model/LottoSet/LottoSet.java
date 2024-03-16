package lotto.Model.LottoSet;
import java.util.List;
import lotto.Model.Lotto.Lotto;
import static lotto.Common.ErrorMessage.*;
public class LottoSet {
    private  List<Lotto> lottoSet;

    public LottoSet(List<Lotto> set ) {
        validateNull(set);
        validateNotEmpty(set);
        this.lottoSet = set;
    }

    private void validateNull(List<Lotto> lottoSet) {
        if (lottoSet == null) {
            throw new IllegalArgumentException(LOTTO_SET_NULL.getMessage());
        }
    }

    private void validateNotEmpty(List<Lotto> lottoSet) {
        if (lottoSet.isEmpty()) {
            throw new IllegalArgumentException(LOTTO_SET_EMPTY.getMessage());
        }
    }


    public List<Lotto> getLottoSet(){

        return this.lottoSet;
    }

}
