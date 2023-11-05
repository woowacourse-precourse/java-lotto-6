package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lottos;
import lotto.Lotto;
import repository.LottoRepository;

import java.util.List;

public class LottoService {

    LottoRepository lottoRepository = new LottoRepository();

    public List<Integer> getProgramRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Long save(Lottos lotto_number) {
        return lottoRepository.save(lotto_number);
    }

    public Long lottoSave(List<List<Integer>> lottosList) {
        return lottoRepository.lottoSave(lottosList);
    }

    public void play() {
        compareLotto();
    }

    public void compareLotto() {

    }
}
