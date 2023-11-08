package Controller;

import Util.*;
import View.InputView;
import View.WinningNumberInputErrorText;
import Domain.WinningNumber.WinningNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
/*
    당첨 번호를 입력 받는 역할을 지닌 객체로써 그 기능은 service쪽에 더 가까우나
    input을 처리하고 view를 가지고 있다는 점에서 controller라고 이름 붙였다.
 */

public class WinningNumberInputController {
    InputView view;
    public String delimeter = ",";
    public int availLength = 6;
    public int lottoNumStart = 1;
    public int lottoNumEnd = 45;

    public WinningNumberInputController(InputView view){
        this.view = view;
    }

    public void tokensCheck(List<String> tokens){
        CheckList.lengthSame(tokens, availLength, WinningNumberInputErrorText.notSixWord());
        CheckList.checkDuplicate(tokens,WinningNumberInputErrorText.dupilicateNumber());
    }

    public void numbersCheck(List<Integer> numbers){
        for(Integer num: numbers){
            CheckInteger.intOutOfRange(num, lottoNumStart, lottoNumEnd, WinningNumberInputErrorText.numberOutOfRange());
        }
    }

    public List<Integer> getNumbersFromConsole(){
        view.introduceNumbersInput();
        String str = Console.readLine();
        CheckNull.check(str, WinningNumberInputErrorText.nullInputAsNumbers());

        List<String> tokens = Arrays.stream(str.split(delimeter)).toList();
        tokensCheck(tokens);

        List<Integer> numbers = Convert.convertStringListToIntegerList(tokens, WinningNumberInputErrorText.CantConvertedToInt());
        numbersCheck(numbers);
        return numbers;
    }

    public List<Integer> recursiveGetNumbersConsole(){
        try{
            return getNumbersFromConsole();
        }catch (IllegalArgumentException e){
            return getNumbersFromConsole();
        }
    }

    public Integer getBonusFromConsole(List<Integer> numbers){
        view.introduceBonusNumberInput();
        Integer num;
        String str = Console.readLine();
        CheckNull.check(str, WinningNumberInputErrorText.nullInputAsBonus());

        num = Convert.convertStringToInteger(str, WinningNumberInputErrorText.CantConvertedToInt());
        CheckInteger.intOutOfRange(num, lottoNumStart, lottoNumEnd, WinningNumberInputErrorText.numberOutOfRange());
        CheckList.checkNotInList(numbers, num, WinningNumberInputErrorText.dupilicateBonusNumber());

        return num;
    }

    public int recursiveGetBonusFromConsole(List<Integer> numbers){
        try{
            return getBonusFromConsole(numbers);
        }catch(IllegalArgumentException e){
            return recursiveGetBonusFromConsole(numbers);
        }
    }

    public WinningNumber getWinningNumberFromConsole(){
        List<Integer> numbers = recursiveGetNumbersConsole();
        int num = recursiveGetBonusFromConsole(numbers);
        return new WinningNumber(numbers, num);
    }
}
