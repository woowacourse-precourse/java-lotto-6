package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;


public class LottoService {

    public List<Lotto> purchaseLottoTickets(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            uniqueNumbers.add(number);
        }
        List<Integer> lottoNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
