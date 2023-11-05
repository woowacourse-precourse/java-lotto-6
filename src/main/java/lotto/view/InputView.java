package lotto.view;

import java.util.List;
import lotto.util.InputUtil;

public class InputView {

    private static final String LOTTO_BUDGET_REQUEST_MESSAGE = "\n구입금액을 입력해 주세요.";

    public static int readAmount(){
        try{
            System.out.println(LOTTO_BUDGET_REQUEST_MESSAGE);
            return InputUtil.readAmount();
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            return readAmount();
        }
    }
}
