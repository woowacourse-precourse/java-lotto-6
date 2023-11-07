package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoBody {
    private final int purchaseMoney;

    private List<Lotto> lottoList = new ArrayList<>();
    private Map<LottoEnum, Integer> prizeResult = new HashMap<>();
    private List<Integer> answerNumbers;
    private int bonus;

    public LottoBody(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;

        for (int i = 0; i < purchaseMoney; i += 1000) {
            this.lottoList.add(new Lotto(lottoGenerator()));
        }

        System.out.println(printLottoList());
    }

    public void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    private String printLottoList() {
        String returnValue = "";
        returnValue += (purchaseMoney/1000) + "개를 구매했습니다.\n";

        for (Lotto lotto : this.lottoList) {
            returnValue += lotto.printString() + "\n";
        }

        return returnValue;
    }

    public String printPrizeResult() {
        getPrizeResult();
        String returnValue = "당첨 통계\n---\n";

        for (LottoEnum result: Arrays.asList(LottoEnum.values())) {
            if (result.equals(LottoEnum.NOTHING)) continue;
            returnValue += result.getDescriptionAndPrize();
            returnValue += " - ";
            returnValue += prizeResult.get(result) + "개\n";
        }

        return returnValue;
    }

    private List<Integer> lottoGenerator() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lotto;
    }


    private void getPrizeResult() {
        Arrays.stream(LottoEnum.values()).forEach(i -> {
            prizeResult.put(i, 0);
        });

        for (int i = 0; i < lottoList.size(); i++) {
            Lotto lotto = lottoList.get(i);
            LottoEnum result = getRank(calcMatch(lotto));
            prizeResult.compute(result, (key, val) -> val + 1);
        }
    }

    private List<Integer> calcMatch(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = 0;
        int bonusCount = 0;

        for (int i = 0; i < answerNumbers.size(); i++) {
            if (lottoNumbers.contains(answerNumbers.get(i))) {
                matchCount++;
            }
        }

        if (lottoNumbers.contains(bonus)) {
            bonusCount += 1;
        }

        return List.of(matchCount, bonusCount);
    }

    private LottoEnum getRank(List<Integer> matchResult) {
        int matchCount = matchResult.get(0);
        int bonusCount = matchResult.get(1);

        if (matchCount + bonusCount == 3) return LottoEnum.RANK5TH;
        if (matchCount + bonusCount == 4) return LottoEnum.RANK4TH;
        if (matchCount + bonusCount == 5) return LottoEnum.RANK3RD;
        if (matchCount == 5 && bonusCount == 1) return LottoEnum.RANK2ND;
        if (matchCount == 6) return LottoEnum.RANK1ST;

        return LottoEnum.NOTHING;
    }

    public String getProfit() {
        int profit = 0;
        for (LottoEnum result : LottoEnum.values()) {
            profit += prizeResult.get(result) * result.getPrize();
        }

        float result = ((float) profit)/purchaseMoney * 100;
        return "총 수익률은 " + String.format("%.1f", result) + "%입니다.";
    }
}
