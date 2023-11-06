package lotto;

import static lotto.LottoSettingValue.FIRST_LOTTO_INDEX;

public class GuideMessage{

    private static final String GUIDE_MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String GUIDE_MSG_NUMBER_OF_PURCHASED_LOTTO = "개를 구매했습니다.";
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
}
