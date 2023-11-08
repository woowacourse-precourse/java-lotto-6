package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    private static LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    public List<Lotto> prodcue(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = random();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> random() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public Map<Integer, Integer> price(List<Lotto> lottos, List<Integer> priceNumbers, int bonusNumber) {
        int[] resultValue = new int[5];

        for (Lotto lotto : lottos) {
            int value = match(lotto, priceNumbers);
            boolean bonusFlag = checkBonus(lotto, bonusNumber);
            resultValue = inputValue(resultValue, value, bonusFlag);
        }
        return resultMap(resultValue);
    }


    public int match(Lotto lotto, List<Integer> priceNumbers) {
        List<Integer> matchList = lotto.getNumbers().
                stream().filter(o -> priceNumbers.stream()
                        .anyMatch(Predicate.isEqual(o))).toList();

        return matchList.size();
    }

    public int[] inputValue(int[] resultValue, int value, boolean bonusFlag) {
        switch (value) {
            case 3:
                resultValue[0]++;
                break;
            case 4:
                resultValue[1]++;
                break;
            case 5:
                if (!bonusFlag) {
                    resultValue[2]++;
                } else {
                    resultValue[3]++;
                }
                break;
            case 6:
                resultValue[4]++;
                break;
        }
        return resultValue;
    }

    public boolean checkBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private Map<Integer, Integer> resultMap(int[] resultValue) {
        Map<Integer, Integer> result = new HashMap<>();
        result.put(5000, resultValue[0]);
        result.put(50000, resultValue[1]);
        result.put(1500000, resultValue[2]);
        result.put(30000000, resultValue[3]);
        result.put(2000000000, resultValue[4]);

        return result;
    }


    public double rate(int number, Map<Integer, Integer> result) {
        int seedMoney = number * 1000;
        int nowMoney = 0;

        for (Integer key : result.keySet()) {
            nowMoney += key * result.get(key);
        }

        double rate = ((double) seedMoney / nowMoney) * 100;
        return rate;
    }
}

