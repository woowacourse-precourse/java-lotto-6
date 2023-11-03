package lotto;

import java.util.*;

public class LottoResultChecker {
    Map<LottoMessage, Integer> lottoResult = new LinkedHashMap<>();

    private final List<Lotto> lottos;
    private final List<String> sixLottoNumbers;
    private final String bonusNumber;

    public LottoResultChecker(List<Lotto> lottos, List<String> sixLottoNumbers, String bonusNumber) {
        this.lottos = lottos;
        this.sixLottoNumbers = sixLottoNumbers;
        this.bonusNumber = bonusNumber;

        lottoResult.put(LottoMessage.THREE, 0);
        lottoResult.put(LottoMessage.FOUR, 0);
        lottoResult.put(LottoMessage.FIVE, 0);
        lottoResult.put(LottoMessage.BONUS, 0);
        lottoResult.put(LottoMessage.SIX, 0);
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
            lottoResult.put(LottoMessage.THREE, lottoResult.get(LottoMessage.THREE) + 1);
        }
        if (winningNumbers.size() == 4) {
            lottoResult.put(LottoMessage.FOUR, lottoResult.get(LottoMessage.FOUR) + 1);
        }
        if (winningNumbers.size() == 5 && !isBonusNumber) {
            lottoResult.put(LottoMessage.FIVE, lottoResult.get(LottoMessage.FIVE) + 1);
        }
        if (winningNumbers.size() == 5 && isBonusNumber) {
            lottoResult.put(LottoMessage.BONUS, lottoResult.get(LottoMessage.BONUS) + 1);
        }
        if (winningNumbers.size() == 6) {
            lottoResult.put(LottoMessage.SIX, lottoResult.get(LottoMessage.SIX) + 1);
        }
    }
}

