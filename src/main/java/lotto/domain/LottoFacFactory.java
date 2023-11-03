package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utill.RandomNumberProvider;

public class LottoFacFactory {

    public static List<Lotto> of(LottoTicket lottoTicket){
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicket.getLottoCount(); i++) {
            lottos.add(createLotto()); // 로또 생성 메서드 호출
        }
        return lottos;
    }

    private static Lotto createLotto() {
        return new Lotto(RandomNumberProvider.getNumbers());
    }


}
