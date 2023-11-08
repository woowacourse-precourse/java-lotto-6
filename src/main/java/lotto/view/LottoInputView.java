package lotto.view;

public class LottoInputView {

    public static final String PRICE_INFO_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INIT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INIT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void priceInfoLog() {
        System.out.println(PRICE_INFO_MESSAGE);
    }


    public void initLottoNumberLog() {
        System.out.println(INIT_LOTTO_NUMBER_MESSAGE);
    }

    public void initLottoBonusNumberLog() {
        System.out.println(INIT_BONUS_NUMBER_MESSAGE);
    }


}
