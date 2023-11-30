package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

import static lotto.LottoPrice.*;

public class LottoCheck {
    LottoCheckResult lottoCheckResult = new LottoCheckResult();

    LottoCheck(LottoCheckResult lottoCheckResult, LottoGroup lottoGroup, LottoWinnerNum lottoWinnerNum) {
        this.lottoCheckResult = lottoCheckResult;
        checkLottoWinnerCount(lottoGroup, lottoWinnerNum);
    }

    private void checkLottoWinnerCount(LottoGroup lottoGroup, LottoWinnerNum lottoWinner) {
        int checkMachine;
        List<Lotto> lottoGroupList = lottoGroup.getGroupLotto();
        List<Integer> winnerNum = lottoWinner.getLottoWinnerNum();
        int bonusNum = lottoWinner.getWinnerBonusNum();
        for (int i = 0; i < lottoGroupList.size(); i++) {
            List<Integer> numbers = (lottoGroupList.get(i).getNumbers());
            checkOneLineWinnerNum(numbers, winnerNum, bonusNum);
        }
    }


    private void checkOneLineWinnerNum(List<Integer> numbers, List<Integer> winnerNumbers, int bonusNum) {
        List<Integer> matchList = numbers.stream().filter(o -> winnerNumbers.stream()
                .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());
        int match = matchList.size();
        int matchCount=checkBonusNum(numbers,match,bonusNum);
        addMatchCount(matchCount);
    }


    private int checkBonusNum(List<Integer> matchList, int match, int bonusNum) {
        int matchCount=match;
        if (match == 5) {
            for (int i = 0; i < matchList.size(); i++) {
                if (matchList.get(i) == bonusNum) {
                    matchCount = match * 10;
                }
            }
        }
        return matchCount;
    }


    private void addMatchCount(int matchCount) {
        if (matchCount == THREE_COUNT.getNumber()) {
            lottoCheckResult.addThreeCount();
        }
        if (matchCount == FOUR_COUNT.getNumber()) {
            lottoCheckResult.addFourCount();
        }
        if (matchCount == FIVE_COUNT.getNumber()) {
            lottoCheckResult.addFiveCount();
        }
        if (matchCount == FIVE_COUNT_WITH_BONUS.getNumber()) {
            lottoCheckResult.addFiveWithBonusCount();
        }
        if (matchCount == SIX_COUNT.getNumber()) {
            lottoCheckResult.addSixCount();
        }
    }

    public LottoCheckResult getLottoCheckResult() {
        return lottoCheckResult;
    }

    public void showLottoCheckResult() {
        System.out.println("3개 일치 (5,000원) - " + lottoCheckResult.getThreeCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoCheckResult.getFourCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoCheckResult.getFiveCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCheckResult.getFiveWithBonusCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoCheckResult.getSixCount() + "개");
    }

}