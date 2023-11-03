package lotto;

import java.util.*;

public class LottoResultChecker {
    Map<String, Integer> lottoResult = new LinkedHashMap<>();

    private final List<Lotto> lottos;
    private final List<String> sixLottoNumbers;
    private final String bonusNumber;

    public LottoResultChecker(List<Lotto> lottos, List<String> sixLottoNumbers, String bonusNumber) {
        this.lottos = lottos;
        this.sixLottoNumbers = sixLottoNumbers;
        this.bonusNumber = bonusNumber;

        lottoResult.put(LottoMessage.THREE.message, 0);
        lottoResult.put(LottoMessage.FOUR.message, 0);
        lottoResult.put(LottoMessage.FIVE.message, 0);
        lottoResult.put(LottoMessage.BONUS.message, 0);
        lottoResult.put(LottoMessage.SIX.message, 0);
    }

    public void calculator() {
        System.out.println("당첨 통계\n---");
        for (Lotto lotto : lottos) {
            List<Integer> winningNumbers = new ArrayList<>(lotto.getSixLottoNumbers());

            boolean isBonusNumber = winningNumbers.contains(Integer.parseInt(bonusNumber));
            winningNumbers.retainAll(stringToInteger(sixLottoNumbers));

            rankCalculator(isBonusNumber, winningNumbers);
        }
    }

    private static List<Integer> stringToInteger(List<String> stringArray) {
        List<Integer> IntegerArray = new ArrayList<>();
        for (String string : stringArray) {
            IntegerArray.add(Integer.parseInt(string));
        }
        return IntegerArray;
    }

    private void rankCalculator(boolean isBonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.size() == 3) {
            lottoResult.put(LottoMessage.THREE.message, lottoResult.get(LottoMessage.THREE.message) + 1);
        }
        if (winningNumbers.size() == 4) {
            lottoResult.put(LottoMessage.FOUR.message, lottoResult.get(LottoMessage.FOUR.message) + 1);
        }
        if (winningNumbers.size() == 5 && !isBonusNumber) {
            lottoResult.put(LottoMessage.FIVE.message, lottoResult.get(LottoMessage.FIVE.message) + 1);
        }
        if (winningNumbers.size() == 5 && isBonusNumber) {
            lottoResult.put(LottoMessage.BONUS.message, lottoResult.get(LottoMessage.BONUS.message) + 1);
        }
        if (winningNumbers.size() == 6) {
            lottoResult.put(LottoMessage.SIX.message, lottoResult.get(LottoMessage.SIX.message) + 1);
        }
    }
}

