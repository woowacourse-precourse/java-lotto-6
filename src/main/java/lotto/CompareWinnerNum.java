package lotto;

public class CompareWinnerNum {
    static int matchCount = 0;
    static int bonusMatchCount = 0;
    static int Match_3_Count = 0;
    static int Match_4_Count = 0;
    static int Match_5_Count = 0;
    static int Match_5_AndBonusCount = 0;
    static int Match_6_Count;

    static void compareNumbers() {
        for (int i = 0; i < OutputView.lottoPurchaseCount; i++) {
            matchCount = 0;
            bonusMatchCount = 0;
            for (int j = 0; j < 6; j++) {
                if (LottoWinnerInput.lottoWinnerNum
                        .contains(LottoTicketGenerator.lottoNumbersDrawnContainer.get(i).get(j))) {
                    matchCount++;
                }
                if ((LottoTicketGenerator.lottoNumbersDrawnContainer.get(i).get(j))
                        .equals(Integer.parseInt(LottoBonusInput.lottoWinnerBonusNum))) {
                    bonusMatchCount++;
                }
            }
            calculateWinningRank();
        }
    }

    static void calculateWinningRank() {
        if (matchCount == 3) {
            Match_3_Count = Match_3_Count + 1;
        }
        if (matchCount == 4) {
            Match_4_Count = Match_4_Count + 1;
        }
        if (matchCount == 5 && bonusMatchCount != 1) {
            Match_5_Count = Match_5_Count + 1;
        }
        if (matchCount == 5 && bonusMatchCount == 1) {
            Match_5_AndBonusCount = Match_5_AndBonusCount + 1;
        }
        if (matchCount == 6) {
            Match_6_Count = Match_6_Count + 1;
        }
    }
}
