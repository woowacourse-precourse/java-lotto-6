package lotto;

import static lotto.LottoSettingValue.FIRST_LOTTO_INDEX;
import static lotto.LottoSettingValue.LOTTO_SIZE;

public class GuideMessage{

    private static final String GUIDE_MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";
    private static final String COMMA = ",";

    public static void ofInputMoney(){
        System.out.println(GUIDE_MSG_INPUT_MONEY);
    }

    public static void ofIssuedLottos(Lottos lottos, int issueNumber){
        System.out.println(issueNumber + "개를 구매했습니다.");
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
        for (int index = 1; index < LOTTO_SIZE ; index++) {
            commaSplitNumbers += COMMA+lotto.getNumber(index);
        }
        return commaSplitNumbers;
    }

}
