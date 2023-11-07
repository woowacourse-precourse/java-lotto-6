package lotto.service;

import static lotto.configurations.SettingValues.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class AutoLottoService {

    private static class SingletonAutoLottoService {
        private static final AutoLottoService AUTO_LOTTO_SERVICE = new AutoLottoService();
    }

    public static AutoLottoService getInstance() {
        return SingletonAutoLottoService.AUTO_LOTTO_SERVICE;
    }

    private AutoLottoService() {
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = generateRandomNumbers();
        List<Integer> lottoNumbers = sortNumbers(randomNumbers);
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
