package lotto;

import static lotto.LottoSettingValue.FIRST_LOTTO_INDEX;

public class GuideMessage{

    private static final String GUIDE_MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_NUMBER_OF_PURCHASED_LOTTO = "개를 구매했습니다.";

    private static final String UNIT_EQUAL = "개 일치";
    private static final String UNIT = "개";
    private static final String GROSS_RETURN = "총 수익률은 %.1f%% 입니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BLANK = " ";
    private static final String WON = "원";

    private static final String BONUS_BALL_EQUAL = "보너스 볼 일치";
    private static final String DASH = "-";

    private static final String LEFT_PARENTHESES = "(";
    private static final String RIGHT_PARENTHESES = ")";
    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";
    public static final String COMMA = ",";
    private static final String LINE_BREAK = "\n";

    public static void ofInputMoney(){
        System.out.println(GUIDE_MSG_INPUT_MONEY);
    }

    public static void ofIssuedLottos(Lottos lottos, int issueNumber){
        System.out.println(LINE_BREAK + issueNumber + GUIDE_MSG_NUMBER_OF_PURCHASED_LOTTO);
        for (int index = 0; index < issueNumber; index++) {
            ofOneLottoNumber(lottos, index);
        }
    }

    public static void ofOneLottoNumber(Lottos lottos, int indexOfLotto){
        Lotto lotto = lottos.getLotto(indexOfLotto);
        System.out.println(LEFT_BRACE+joinCommaWithNumbers(lotto)+RIGHT_BRACE);
    }

    private static String joinCommaWithNumbers(Lotto lotto){
        String commaSplitNumbers = "";
        commaSplitNumbers += lotto.getNumber(FIRST_LOTTO_INDEX);
        for (int index = 1; index < lotto.getSize() ; index++) {
            commaSplitNumbers += COMMA+lotto.getNumber(index);
        }
        return commaSplitNumbers;
    }

    public static void ofInputWinningNumber(){
        System.out.println(GUIDE_MSG_INPUT_WINNING_NUMBER);
    }

    public static void ofInputBounsNumber(){
        System.out.println(LINE_BREAK+GUIDE_MSG_INPUT_BONUS_NUMBER);
    }

    public static void ofLottoWinnerResult(LottoResultWinners lottoResultWinners, Double earningRate){
        System.out.println(LINE_BREAK+WINNING_STATISTICS);
        System.out.println(DASH+DASH+DASH);
        for (Rank rank : Rank.values()) {
            Integer numberOfWinner = lottoResultWinners.getNumberOfWinner(rank);
            if(isFiveMatchBonusRank(rank)){
                printFiveMatchBonusResult(rank, numberOfWinner);
                continue;
            }
            printLottoMatchResult(rank, numberOfWinner);
        }
        System.out.printf(GROSS_RETURN,earningRate);
    }

    private static boolean isFiveMatchBonusRank(Rank rank) {
        return rank.getNumberOfMatch() == Rank.FIVE_MATCH_BONUS.getNumberOfMatch()
                && rank.getBonus() == Rank.FIVE_MATCH_BONUS.getBonus();
    }

    private static void printFiveMatchBonusResult(Rank rank, Integer numberOfWinner){
        System.out.println(rank.getNumberOfMatch()+UNIT_EQUAL+COMMA+BONUS_BALL_EQUAL+BLANK+LEFT_PARENTHESES
                +rank.getPrizeMoney()+WON+RIGHT_PARENTHESES+BLANK+DASH+BLANK+numberOfWinner+UNIT);
        return;
    }

    private static void printLottoMatchResult(Rank rank, Integer numberOfWinner) {
        System.out.println(
                rank.getNumberOfMatch()+UNIT_EQUAL+BLANK+LEFT_PARENTHESES +rank.getPrizeMoney()+WON
                        +RIGHT_PARENTHESES+BLANK+DASH+BLANK+numberOfWinner+UNIT);
        return;
    }
}

