package view;

import enums.ExceptionMessage;
import enums.Message;

public class OutputView {

    public void printRequirelottoCost(){
        System.out.println(Message.REQUIRE_PURCHASE_MONEY.getMessage());
    }

    public void printPublishedLotto(int lottoPaper){
        System.out.printf("%d%s", lottoPaper, Message.PUBLISHED_LOTTO.getMessage());
    }

    public void printIlligalLottoCostMessage(){
        System.out.println(ExceptionMessage.ILLIGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
    }

}
