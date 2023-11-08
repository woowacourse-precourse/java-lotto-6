package lotto;

import java.util.List;

public class Output {

    static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    static final String LOTTO_PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구매 금액은 1000원 단위로 입력해주세요.";
    static final String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottoPurchaseCountMessage(int count){
        System.out.println(count + LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos){
        lottos.forEach(lotto -> System.out.println(lotto));
    }
}
