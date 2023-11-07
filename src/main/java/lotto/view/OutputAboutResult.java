package lotto.view;

import lotto.constant.Phrases;
import lotto.constant.Rank;

public class OutputAboutResult {
    public static void printIntroduceWinnerResult() {
        System.out.println();
        System.out.println(Phrases.totalPhrase);
        System.out.println(Phrases.linePhrase);
    }

    public static void printWinnerResult(int[] resultCount) {
        System.out.println(Phrases.correctThreePhrase + resultCount[Rank.FOURTH.getMatchCount()] + Phrases.countPhrase);
        System.out.println(Phrases.correctFourPhrase + resultCount[Rank.THIRD.getMatchCount()] + Phrases.countPhrase);
        System.out.println(Phrases.correctFivePhrase + resultCount[Rank.SECOND.getMatchCount()] + Phrases.countPhrase);
        System.out.println(Phrases.correctFiveBonusPhrase + resultCount[Rank.SECOND_WITH_BONUS.getMatchCount()] + Phrases.countPhrase);
        System.out.println(Phrases.correctSixPhrase + resultCount[Rank.FIRST.getMatchCount()] + Phrases.countPhrase);
    }

    public static void printRateOfReturn(float rateOfReturn) {
        System.out.println(Phrases.rateOfReturnPhrase + rateOfReturn + Phrases.confirmPhrase);
    }
}
