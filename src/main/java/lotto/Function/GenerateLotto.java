package lotto.Function;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateLotto {

    public List<Lotto> generateLottoTickets(int ticket) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottoTickets.add(generateLottoNumber());
        }
        return lottoTickets;
    }

    public Lotto generateLottoNumber() {
        GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();
        return new Lotto(generateLottoNumbers.generateLotto_RandomNumbers());
    }


}
