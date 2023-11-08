package lotto;

import static Constant.GuideMessagePiece.BLANK;
import static Constant.GuideMessagePiece.BONUS_BALL_EQUAL;
import static Constant.GuideMessagePiece.COMMA;
import static Constant.GuideMessagePiece.DASH;
import static Constant.GuideMessagePiece.LEFT_BRACE;
import static Constant.GuideMessagePiece.LEFT_PARENTHESES;
import static Constant.GuideMessagePiece.LINE_BREAK;
import static Constant.GuideMessagePiece.RIGHT_BRACE;
import static Constant.GuideMessagePiece.RIGHT_PARENTHESES;
import static Constant.GuideMessagePiece.UNIT;
import static Constant.GuideMessagePiece.UNIT_EQUAL;
import static Constant.GuideMessagePiece.WON;
import static Constant.LottoSettingValue.FIRST_LOTTO_INDEX;

public class GuideMessage{

    private static final String GUIDE_MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_NUMBER_OF_PURCHASED_LOTTO = "개를 구매했습니다.";
    private static final String GROSS_RETURN = "총 수익률은 %.1f%%입니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통계";



    public static void ofInputMoney(){
        System.out.println(GUIDE_MSG_INPUT_MONEY);
    }

    public static void ofIssuedLottos(Lottos lottos, Integer issueNumber){
        System.out.println(LINE_BREAK + issueNumber + GUIDE_MSG_NUMBER_OF_PURCHASED_LOTTO);
        for (Integer index = 0; index < issueNumber; index++) {
            ofOneLottoNumber(lottos, index);
        }
    }

    public static void ofOneLottoNumber(Lottos lottos, Integer indexOfLotto){
        Lotto lotto = lottos.getLotto(indexOfLotto);
        System.out.println(LEFT_BRACE+joinCommaWithNumbers(lotto)+RIGHT_BRACE);
    }

    private static String joinCommaWithNumbers(Lotto lotto){
        String commaSplitNumbers = "";
        commaSplitNumbers += lotto.getNumber(FIRST_LOTTO_INDEX);
        for (Integer index = 1; index < lotto.getSize() ; index++) {
            commaSplitNumbers += COMMA+BLANK+lotto.getNumber(index);
        }
        return commaSplitNumbers;
    }

    public static void ofInputWinningNumber(){
        System.out.println(LINE_BREAK+GUIDE_MSG_INPUT_WINNING_NUMBER);
    }

    public static void ofInputBounsNumber(){
        System.out.println(LINE_BREAK+GUIDE_MSG_INPUT_BONUS_NUMBER);
    }

    public static void ofLottoWinnerResult(LottoResultWinners lottoResultWinners, Double earningRate){
        System.out.println(LINE_BREAK+WINNING_STATISTICS);
        System.out.println(DASH+DASH+DASH);
        for (Rank rank : Rank.values()) {
            Integer numberOfWinner = lottoResultWinners.getNumberOfRankWinner(rank);
            if(Rank.isFiveMatchBonusRank(rank)){
                printFiveMatchBonusResult(rank, numberOfWinner);
                continue;
            }
            printLottoMatchResult(rank, numberOfWinner);
        }
        System.out.printf(GROSS_RETURN,earningRate);
    }

    private static void printLottoMatchResult(Rank rank, Integer numberOfWinner) {
        System.out.println(
                rank.getNumberOfMatch()+UNIT_EQUAL+BLANK+LEFT_PARENTHESES +rank.getPrizeMoney()+WON
                        +RIGHT_PARENTHESES+BLANK+DASH+BLANK+numberOfWinner+UNIT);
        return;
    }
    
    private static void printFiveMatchBonusResult(Rank rank, Integer numberOfWinner){
        System.out.println(rank.getNumberOfMatch()+UNIT_EQUAL+COMMA+BLANK+BONUS_BALL_EQUAL+BLANK+LEFT_PARENTHESES
                +rank.getPrizeMoney()+WON+RIGHT_PARENTHESES+BLANK+DASH+BLANK+numberOfWinner+UNIT);
        return;
    }

}

