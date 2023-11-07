package view;

import enums.ExceptionMessage;
import enums.Message;
import java.util.List;

public class OutputView {

    public void printRequirelottoCost(){
        System.out.println(Message.REQUIRE_PURCHASE_MONEY.getMessage());
    }

    public void printPublishedLotto(int lottoPaper){
        System.out.printf("%d%s\n", lottoPaper, Message.PUBLISHED_LOTTO.getMessage());
    }

    public void printMyLottoNumber(List<Integer> myLottoNumber){
        System.out.println(myLottoNumber);
    }

    public void printRequireWinningNumber(){
        printNewLine();
        System.out.println(Message.REQUIRE_WINNING_NUMBER.getMessage());
    }

    public void printRequireBonusNumber(){
        printNewLine();
        System.out.println(Message.REQUIRE_BONUS_NUMBER.getMessage());
    }

    public void printMatchResult(){
        printNewLine();
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        printSplitLine();
    }

    public void printNewLine(){
        System.out.print(Message.NEW_LINE.getMessage());
    }

    public void printSplitLine(){
        System.out.println(Message.SPLIT_LINE.getMessage());
    }

    public void printIlligalLottoCostMessage(){
        System.out.println(ExceptionMessage.ILLIGAL_COST_ERROR_MESSAGE.getMessage());
    }

    public void printIlligalWinningNumberMessage(){
        System.out.println(ExceptionMessage.ILLIGAL_WINNING_NUM_MESSAGE.getMessage());
    }
}
