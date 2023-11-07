package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Constants.INVALID_MONEY_FORMAT;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Integer getPurchaseAmount() throws NumberFormatException{
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");

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
        System.out.println("당첨 번호를 입력해 주세요.");

        return stringToIntegerList(Console.readLine());
    }

    public Integer getInputBonusNumber(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

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
