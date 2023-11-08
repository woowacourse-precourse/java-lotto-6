package lotto.service;

import static lotto.configurations.SettingValues.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.repository.LottoRepository;


public class LottoService {

    LottoRepository lottoRepository;

    private static class SingletonAutoLottoService {
        private static final LottoService AUTO_LOTTO_SERVICE = new LottoService();
    }

    public static LottoService getInstance() {
        return SingletonAutoLottoService.AUTO_LOTTO_SERVICE;
    }

    private LottoService() {
        lottoRepository = LottoRepository.getInstance();
    }

    public List<Integer> generateLottos() {
        List<Integer> randomNumbers = generateRandomNumbers();
        List<Integer> lottoNumbers = sortNumbers(randomNumbers);

        Lotto newLotto = new Lotto(lottoNumbers);
        lottoRepository.addLotto(newLotto);

        return lottoNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers;
        randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_OF_RANGE.get(), MAX_OF_RANGE.get(), SIZE_OF_LOTTO.get());
        return randomNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> numberList) {
        List<Integer> sortedNumbersList;
        sortedNumbersList = numberList.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());
        return sortedNumbersList;
    }
}
