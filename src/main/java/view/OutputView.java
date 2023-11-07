package view;

import enums.Constants;
import enums.ExceptionMessage;
import enums.Message;
import java.util.List;
import lotto.Lotto;

public class OutputView {
    private int size = Integer.parseInt(Constants.LOTTO_NUMBER_SIZE.getConst());

    public void printRequirelottoCost(){
        System.out.println(Message.REQUIRE_PURCHASE_MONEY.getMessage());
    }

    public void printPublishedLotto(int lottoPaper){
        System.out.printf("%d%s\n", lottoPaper, Message.PUBLISHED_LOTTO.getMessage());
    }

    public void printNewLine(){
        System.out.print(Message.NEW_LINE.getMessage());
    }

    public void printMyLottoNumber(List<Integer> myLottoNumber){
        System.out.println(myLottoNumber);
    }

    public void printIlligalLottoCostMessage(){
        System.out.println(ExceptionMessage.ILLIGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
    }

}
