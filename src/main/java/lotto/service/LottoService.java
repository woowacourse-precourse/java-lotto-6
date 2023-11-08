package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.Lotto.Rank;

public class LottoService {
    private final int LOTTO_PRICE = 1000;
    public int checkLottoNumber(String purchaseAmount) {
        return convertToInt(purchaseAmount) / LOTTO_PRICE;
    }

    public Lotto generateLotto() {
        List<Integer> lottoNumber = new ArrayList<>(generateRandomNumber());
        Collections.sort(lottoNumber);
        Lotto lotto = new Lotto(lottoNumber);
        return lotto;
    }


    public Map<Rank, Integer> checkwin(String winningNumber, String bonusNumber, List<Lotto> lottos) {
        List<Integer> winningLottoNumbers = convertStringToList(winningNumber);
        int bonusLottoNumber = convertToInt(bonusNumber);

        return checkRankCounts(lottos, winningLottoNumbers,bonusLottoNumber);
    }

    private Map<Rank, Integer> checkRankCounts(List<Lotto> lottos, List<Integer> winningLottoNumbers, int bonusLottoNumber) {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.checkRank(winningLottoNumbers, bonusLottoNumber);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }

    private List<Integer> convertStringToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int convertToInt(String purchaseAmount) {
        validatePurchasePrice(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchasePrice(String purchasePrice) {
        if(!purchasePrice.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
        }
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public double calculateEarningRate(int totalEarnings, int purchasePrice) {
        return (double) totalEarnings / purchasePrice * 100;
    }

    public int calculateTotalEarning(Map<Rank, Integer> rankCounts) {
        int totalEarnings = 0;

        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalEarnings += (int) (entry.getKey()
                                .getWinningMoney() * entry.getValue());
        }
        return totalEarnings;
    }

}
