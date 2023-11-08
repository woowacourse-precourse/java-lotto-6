package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.controller.WinningNumberController;

public class UserInputView {

    private final  WinningNumberController winningNumberController = WinningNumberController.getInstance();
    private final LottoController lottoController = LottoController.getInstance();

    private UserInputView() {
    }
    private static class UserInputViewHolder{
        private static final UserInputView userInputView = new UserInputView();
    }

    public static UserInputView getInstance(){
        return UserInputViewHolder.userInputView;
    }

    public void inputPurchaseAmount(){
        try{
            lottoController.buyLottoTickets(Long.parseLong(Console.readLine()));

        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputPurchaseAmount();
        }
    }

    public void inputWinningNums(){
        try{
            winningNumberController.putWinningNums(Console.readLine());

        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputWinningNums();
        }
    }

    public void inputBonusNum(){
        try{
            winningNumberController.putBonusNum(Console.readLine());
        }catch (IllegalArgumentException e){
            exceptionTypeMessage(e);
            inputBonusNum();
        }
    }

    private void exceptionTypeMessage(IllegalArgumentException e){
        if(e instanceof NumberFormatException){
            System.out.println(ExceptionMessage.NumberFormatError.getErrorMessage());
            return;
        }
        if(e instanceof IllegalArgumentException){
            System.out.println(e.getMessage());
        }
    }
}
