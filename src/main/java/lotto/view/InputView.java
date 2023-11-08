package lotto.view;

import java.util.List;
import lotto.util.InputUtil;

public class InputView {

    private static final String LOTTO_BUDGET_REQUEST_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";



    public static int readAmount(){
        try{
            System.out.println(LOTTO_BUDGET_REQUEST_MESSAGE);
            return InputUtil.readAmount();
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            return readAmount();
        }
    }

    public static List<Integer> readWinningNumbers(){
        try{
            System.out.println(LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE);
            return InputUtil.readWinningNumbers();
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            return readWinningNumbers();
        }
    }

    public static int readBonus(){
        try{
            System.out.println(LOTTO_BONUS_NUMBER_REQUEST_MESSAGE);
            return InputUtil.readBonus();
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            return readBonus();
        }
    }
}
