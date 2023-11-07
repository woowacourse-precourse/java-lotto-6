package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Constants.*;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Integer getPurchaseAmount() throws NumberFormatException{
        System.out.println();
        System.out.println(INPUT_PURCHASE_AMOUNT);

        int result;

        try{
            result = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_MONEY_FORMAT);
        }

        return result;
    }

    public List<Integer> getInputNumbers(){
        System.out.println();
        System.out.println(INPUT_GOAL_NUMBER);

        return stringToIntegerList(Console.readLine());
    }

    public Integer getInputBonusNumber(){
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);

        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> stringToIntegerList(String string){
        List<Integer> inputList = new ArrayList<>();

        String[] result = string.split(",");

        for (String s : result) {
            inputList.add(Integer.parseInt(s));
        }

        return inputList;
    }
}
