package lotto.view;

import lotto.constant.Phrases;

public class OutputAboutResult {
    public static void printIntroduceWinnerResult() {
        System.out.println();
        System.out.println(Phrases.totalPhrase);
        System.out.println(Phrases.linePhrase);
    }

    public static void printWinnerResult(int[] resultCount) {
        System.out.println(Phrases.correctThreePhrase+resultCount[3]+Phrases.countPhrase);
        System.out.println(Phrases.correctFourPhrase+resultCount[4]+Phrases.countPhrase);
        System.out.println(Phrases.correctFivePhrase+resultCount[5]+Phrases.countPhrase);
        System.out.println(Phrases.correctFiveBonusPhrase+resultCount[7]+Phrases.countPhrase);
        System.out.println(Phrases.correctSixPhrase+resultCount[6]+Phrases.countPhrase);
    }

    public static void printRateOfReturn(float rateOfReturn){
        System.out.println(Phrases.rateOfReturnPhrase+rateOfReturn+Phrases.confirmPhrase);
    }
}
