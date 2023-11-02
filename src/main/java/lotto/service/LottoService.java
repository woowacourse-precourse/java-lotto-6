package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottosDto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public LottosDto generateLottos(LottoNumberDto dto) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < dto.numberOfLottos(); i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return new LottosDto(lottos);
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
