package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private static final int LOTTO_SIZE = 6;

    public static int getInputMoney() {
        PrintManager.printInputMoney();
        String line = Console.readLine();
        int money = 0;
        try {
            money = Integer.parseInt(line);
            if (money % 1000 != 0 || money < 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ILLEGAL_ARGUMENT_MONEY.getMessage());
            return getInputMoney();
        }
        return money;
    }

    public static List<Integer> getInputWinNumbers() {
        PrintManager.printInputWinNumbers();
        String line = Console.readLine();
        String[] numbers = line.split(",");
        List<Integer> lottoNumbers;

        try{
            if(numbers.length != LOTTO_SIZE)
                throw new IllegalArgumentException();
            lottoNumbers = makeNumbersInteger(numbers);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorMessage.ILLEGAL_ARGUMENT_NUMBERS_FORMAT.getMessage());
            return getInputWinNumbers();
        }

        return lottoNumbers;
    }

    private static List<Integer> makeNumbersInteger(String[] numbers) throws IllegalArgumentException{
        List<Integer> lottoNumbers = new ArrayList<>();

        for(int i = 0 ; i < LOTTO_SIZE; i++)
            lottoNumbers.add(Integer.parseInt(numbers[i]));

        return lottoNumbers;
    }

    public static int getInputBonusNumber() {
        PrintManager.printBonusNumberInput();
        String line = Console.readLine();
        int bonusNumber;

        try{
            bonusNumber = Integer.parseInt(line);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorMessage.ILLEGAL_ARGUMENT_MONEY.getMessage());
            return getInputBonusNumber();
        }

        return bonusNumber;
    }
}
