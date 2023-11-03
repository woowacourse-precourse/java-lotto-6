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

        lottoResult.put("3개 일치 (5,000원) - %d개", 0);
        lottoResult.put("4개 일치 (50,000원) - %d개", 0);
        lottoResult.put("5개 일치 (1,500,000원) - %d개", 0);
        lottoResult.put("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 0);
        lottoResult.put("6개 일치 (2,000,000,000원) - %d개", 0);
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
            lottoResult.put("3개 일치 (5,000원) - %d개", lottoResult.get("3개 일치 (5,000원) - %d개") + 1);
        }
        if (winningNumbers.size() == 4) {
            lottoResult.put("4개 일치 (50,000원) - %d개", lottoResult.get("4개 일치 (50,000원) - %d개") + 1);
        }
        if (winningNumbers.size() == 5 && !isBonusNumber) {
            lottoResult.put("5개 일치 (1,500,000원) - %d개", lottoResult.get("5개 일치 (1,500,000원) - %d개") + 1);
        }
        if (winningNumbers.size() == 5 && isBonusNumber) {
            lottoResult.put("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", lottoResult.get("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개") + 1);
        }
        if (winningNumbers.size() == 6) {
            lottoResult.put("6개 일치 (2,000,000,000원) - %d개", lottoResult.get("6개 일치 (2,000,000,000원) - %d개") + 1);
        }
    }
}

