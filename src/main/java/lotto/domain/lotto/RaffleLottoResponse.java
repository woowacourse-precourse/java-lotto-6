 package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.global.enums.Separator;

public class RaffleLottoResponse {

    private final Lotto lotto;

    public RaffleLottoResponse(Lotto lotto){
        this.lotto = lotto;
    }

    public Lotto getLotto(){
        return this.lotto;
    }

    @Override
    public String toString(){
        return Separator.NONE.toString();
    }

}
