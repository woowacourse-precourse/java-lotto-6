package lotto.lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.dto.LottoDto;
import lotto.lotto.repository.LottoRepository;

import java.util.Collections;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void createLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottoRepository.saveLotto(getRandomNumbers());
        }
    }

    @Override
    public List<LottoDto> getLottos() {
        return lottoRepository.findAll();
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
