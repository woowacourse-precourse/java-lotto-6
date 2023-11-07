package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.config.LottoConfig.*;

public class LottoNumber {

    public List<Integer> lottoRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue()
                , LOTTO_MAX_NUMBER.getValue(), LOTTO_COUNT.getValue());

        return numbers;
    }

    public List<Lotto> lottoTickets(int lottoCount) {

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = new ArrayList<>(lottoRandomNumber());
            Collections.sort(lottoNumber);

            OutputView.lottoNumberOutputMessage(lottoNumber);

            Lotto lotto = new Lotto(lottoNumber);
            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }

}
