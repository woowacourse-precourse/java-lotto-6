package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.SingletonRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.ErrorMessage.*;
import static lotto.model.LottoInfo.*;

public class InputView {
    private InputView(){}
    public static InputView getInstance(){
        String key = "InputView";
        if(SingletonRegistry.getInstance(key)==null){
            SingletonRegistry.register(key,new InputView());
        }
        return (InputView) SingletonRegistry.getInstance(key);
    }

    public int inputPayment(){
        String input = Console.readLine();
        validPayment(input);
        return Integer.parseInt(input);
    }

    private void validPayment(String input){
        try {
            int payment = Integer.parseInt(input);
            if(payment%LOTTO_PRICE!=0)
                throw new IllegalArgumentException(PAYMENT_ERROR.toString());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_ERROR.toString());
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    public List<Integer> inputNumbers(){
        String input = Console.readLine();
        validNumbers(input);
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void validNumbers(String input){
        try {
            String[] stringNums = input.split(",");
            if(stringNums.length!=NUMBER_COUNT)
                throw new IllegalArgumentException(SIZE_ERROR.toString());
            for(String num : stringNums){
                validNumber(num);
            }
        } catch (IllegalArgumentException e){
            throw e;
        } catch (Exception e){
            throw new IllegalArgumentException(ERROR_MESSAGE.toString());
        }
    }
    public int inputNumber(){
        String input = Console.readLine();
        validNumber(input);
        return Integer.parseInt(input);
    }

    private void validNumber(String input){
        try {
            int payment = Integer.parseInt(input);
            if(payment<START_NUMBER || payment>END_NUMBER)
                throw new IllegalArgumentException(RANGE_ERROR.toString());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_ERROR.toString());
        }catch (IllegalArgumentException e){
            throw e;
        }
    }
}
