package lotto.controller;

import lotto.Lotto;

import java.util.List;

public class MessageManager {
    public static final String ADD_COIN = "구입금액을 입력해 주세요.";
    public static final String BUY_LOTTOS = "개를 구매했습니다.";

    public static final String ERROR_IS_NOT_NUMBER = "[ERROR] 금액은 숫자로 입력해야 합니다.";
    public static final String ERROR_IS_NOT_1000_UNIT = "[ERROR] 금액은 1,000원 단위로만 입력해야 합니다.";

    public void buyLottos(int count, List<Lotto> lottos){
        System.out.println(count + BUY_LOTTOS);
        for(int i =0 ;i<count; i++){
            lottos.get(i).showNumbers();
        }
    }
}
