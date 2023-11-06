package domain.generator;

import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottoTicket(int count) {
        List<Lotto> lottoTicket = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTicket.add(generateOneLotto());
        }

        return lottoTicket;
    }

    public Lotto generateOneLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return new Lotto(lottoNumberGenerator.generateLottoNumber());
    }

}
