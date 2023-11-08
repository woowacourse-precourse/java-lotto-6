package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.Lotto.Rank;

public class LottoService {
    private final int LOTTO_PRICE = 1000;
    public int checkLottoAmount(String purchasePrice) {
        isPurchasePriceCorrectUnit(purchasePrice);
        return convertToInt(purchasePrice) / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoAmount, List<Lotto> lottos) {
        IntStream.range(0,lottoAmount)
                .forEach(i -> lottos.add(generateLotto()));
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumber = new ArrayList<>(generateRandomNumber());
        Collections.sort(lottoNumber);
        Lotto lotto = new Lotto(lottoNumber);
        return lotto;
    }

    public Map<Rank, Integer> checkwin(String winningNumber, String bonusNumber, List<Lotto> lottos) {
        List<Integer> winningLottoNumbers = convertStringToList(winningNumber);
        validateWinningNumbers(winningLottoNumbers);

        int bonusLottoNumber = convertToInt(bonusNumber);
        validateBonusNumber(bonusLottoNumber);

        return checkRankCounts(lottos, winningLottoNumbers,bonusLottoNumber);
    }

    public void validateWinningNumbers(List<Integer> winningLottoNumbers) {
        if(!winningLottoNumbers.stream()
                .allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if(!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void isPurchasePriceCorrectType(String purchasePrice) {
        if(!purchasePrice.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
        }
    }

    private void isPurchasePriceCorrectUnit(String purchasePrice) {
        if (convertToInt(purchasePrice) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위입니다.");
        }
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

    private int convertToInt(String purchasePrice) {
        isPurchasePriceCorrectType(purchasePrice);
        return Integer.parseInt(purchasePrice);
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
