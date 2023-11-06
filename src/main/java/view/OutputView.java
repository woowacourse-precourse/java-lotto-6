package view;

import enums.Constants;
import enums.ExceptionMessage;
import enums.Message;
import java.util.ArrayList;
import java.util.List;

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

    public void printMyLottoNumber(ArrayList<List<Integer>> myLottoNumber){
        for (List<Integer> integers : myLottoNumber) {
            System.out.println(integers);
        }
    }

    public void printIlligalLottoCostMessage(){
        System.out.println(ExceptionMessage.ILLIGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
    }

}
