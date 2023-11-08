package lotto.view;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;


public class Input {
    private static String stringInput() throws IllegalArgumentException{
        return Console.readLine();
    }
    public static int moneyInput() throws IllegalArgumentException{
        String result;
        result = stringInput();
        moneyValidate(result);
        return Integer.parseInt(result);
    }
    public static ArrayList<Integer> winnigInput() throws IllegalArgumentException{
        String result;
        result = stringInput();
        lottoInputValidate(result);
        String[] resultArray = result.split(",");
        ArrayList<Integer> resultList = new ArrayList<>();
        Arrays.stream(resultArray)
                .map(Integer::parseInt)
                .forEach(resultList::add);
        return resultList;
    }

    public static int bonusInput() throws IllegalArgumentException{
        String result;
        result = stringInput();
        bonusValidate(result);
        return Integer.parseInt(result);
    }

    public static void moneyValidate(String string) throws IllegalArgumentException {
        IMoneyValidation.moneyValidation(new ViewValidation(), string);
    }

    public static void bonusValidate(String string) throws IllegalArgumentException {
        IBonusValidation.bonusValidation(new ViewValidation(), string);
    }

    public static void lottoInputValidate(String string) throws IllegalArgumentException{
        ILottoInputValidation.lottoInputValidation(new ViewValidation(), string);
    }

}
