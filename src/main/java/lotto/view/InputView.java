package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidate;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    final private static String START_MESSAGE = "구입금액을 입력해 주세요.";
    final private static String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    final private static String BONUS_NUMBER_INPUT_MESSAE ="보너스 번호를 입력해 주세요.";


    public static int getLottoNumber(){
        System.out.println(START_MESSAGE);
        String number = Console.readLine();
        try{
            InputValidate.validateIsNumber(number);
            InputValidate.validateIsDivideThousand(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoNumber();
        }
        return Integer.parseInt(number)/1000;
    }

    public static List<Integer> inputWonLottoNumbers(){
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        String number = Console.readLine();
        try{
            InputValidate.validateIsNumberOrRest(number);
            InputValidate.validateIsSizeCorrect(number);
            InputValidate.validateIsRestCorrect(number);
            InputValidate.validateIsCorrectRange(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWonLottoNumbers();
        }
        return convertToList(number);
    }

    private static List<Integer> convertToList(String number){
        String numbers[] = number.split(",");
        List<Integer> numberLIst = new ArrayList<>();
        for(String num:numbers){
            numberLIst.add(Integer.parseInt(num));
        }
        return numberLIst;
    }

    public static int inputBonusNumber(List<Integer> lottoNumbers){
        System.out.println(BONUS_NUMBER_INPUT_MESSAE);
        String number = Console.readLine();
        try{
            InputValidate.validateIsNumber(number);
            InputValidate.validateIsCorrectRange(number);
            InputValidate.validateDuplicateNumber(lottoNumbers,number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber(lottoNumbers);
        }
        return Integer.parseInt(number);
    }
}
