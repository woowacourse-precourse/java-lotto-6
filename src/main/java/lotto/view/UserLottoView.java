package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserLottoView {
    private static final String BUY_MESSAGE="구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_MESSAGE="당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_MESSAGE="보너스 번호를 입력해 주세요.";
    public String inputBuyPrice(){
        System.out.println(BUY_MESSAGE);
        String buyPrice =readLine();
        return buyPrice;
    }
    public String inputUserLottoNumber(){
        System.out.println(INPUT_LOTTO_MESSAGE);
        String userLottoNumber = readLine();
        return userLottoNumber;
    }
    public String inputUserBonusLotto(){
        System.out.println(INPUT_BONUS_LOTTO_MESSAGE);
        String userBonusLotto = readLine();
        return userBonusLotto;
    }

}
