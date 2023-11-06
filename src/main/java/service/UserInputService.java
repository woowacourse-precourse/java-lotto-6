package service;

import static util.ErrorMessage.AMOUNT_MUST_BE_DIVIDED_BY_PRICE;
import static util.ErrorMessage.ONLY_INPUT_NUMBER;
import static util.LottoValidationValue.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class UserInputService {

    private static String input() {
        return Console.readLine();
    }

    // amount
    public static int amount() {
        return checkIsDivideByLottoPrice(checkIsNumber());
    }

    private static int checkIsNumber() {
        while (true) {
            try {
                return Integer.parseInt(input());
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
            }
        }
    }

    private static int checkIsDivideByLottoPrice(int input) {
        if (input % LOTTO_PRICE.get() != 0) {
            System.out.println(AMOUNT_MUST_BE_DIVIDED_BY_PRICE.get());
            return amount();
        }

        return input / LOTTO_PRICE.get();
    }

    //lotto
    public static Lotto lotto() {
        List<Integer> numbers = new ArrayList<>();

        while(true){
            if(checkIsNumberList(input().split(","),numbers)){
                System.out.println(numbers);
                Lotto lotto = MakeObjectService.lotto(numbers);
                if(lotto.isValid()){
                    return lotto;
                }
            }
        }
    }

    private static boolean checkIsNumberList(String[] input, List<Integer> numbers){
        int count = 0;
        while(count < input.length){
            try{
                numbers.add(Integer.parseInt(input[count]));
                count++;
            } catch (IllegalArgumentException e){
                System.out.println(ONLY_INPUT_NUMBER.get());
                numbers.clear();
                return false;
            }
        }
        return true;
    }
}
