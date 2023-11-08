package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.enums.MessageType;

import java.util.*;

public class InputUtils {

    private static final int INPUT_SIZE = 6;
    private static final int MIN_AMOUNT = 1;
    private static final int MAX_AMOUNT = 45;

    public static int inputAmount(){
        try {
            int amount = Integer.parseInt(Console.readLine());
            if(invalidAmount(amount)){
                OutputUtils.printBasicMessage(MessageType.ERROR_NOT_OF_THOUSAND);
                throw new IllegalStateException();
            }

            return amount;
        } catch (IllegalArgumentException e) {
            OutputUtils.printBasicMessage(MessageType.ERROR_NON_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputWinningNumbers(){
        String rawWinningInput = Console.readLine();
        checkWinningInput(rawWinningInput);

        return parseRawWinningInput(rawWinningInput);
    }

    public static int inputBonusNumber(List<Integer> winningNumbers){
        String rawBonusInput = Console.readLine();
        try{
            int num = Integer.parseInt(rawBonusInput);
            checkNumberOutOfBounds(num);
            checkDuplicateBonusNumber(winningNumbers, num);

            return num;
        }catch (IllegalArgumentException e){
            OutputUtils.printBasicMessage(MessageType.ERROR_NON_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static void checkWinningInput(String input) {
        String[] arr = input.split(",");
        if(arr.length != INPUT_SIZE){
            OutputUtils.printBasicMessage(MessageType.ERROR_INCORRECT_NUMBER_OF_INPUTS);
            throw new IllegalArgumentException();
        }

        checkEachWinningNumber(arr);
    }

    private static void checkEachWinningNumber(String[] arr) {
        for(int i = 0; i < INPUT_SIZE; i++){
            try {
                int num = Integer.parseInt(arr[i]);
                checkNumberOutOfBounds(num);
            } catch (IllegalArgumentException e) {
                OutputUtils.printBasicMessage(MessageType.ERROR_NON_NUMBER);
                throw new IllegalArgumentException();
            }
        }

        checkDuplicateWinningNumbers(arr);
    }

    private static void checkDuplicateWinningNumbers(String[] arr) {
        Set<Integer> usedNumbers = new HashSet<>();
        for(int i = 0; i < INPUT_SIZE; i++){
            usedNumbers.add(Integer.parseInt(arr[i]));
        }

        if(usedNumbers.size() != INPUT_SIZE){
            OutputUtils.printBasicMessage(MessageType.ERROR_DUPLICATE_WINNING_INPUTS);
            throw new IllegalArgumentException();
        }
    }

    private static boolean invalidAmount(int amount) {
        return amount % 1000 != 0;
    }

    private static List<Integer> parseRawWinningInput(String input) {
        String[] arr = input.split(",");
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < INPUT_SIZE; i++){
            result.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(result);

        return result;
    }

    private static void checkNumberOutOfBounds(int num) {
        if(isNumberOutOfBounds(num)){
            OutputUtils.printBasicMessage(MessageType.ERROR_OUT_OF_BOUNDS);
            throw new IllegalStateException();
        }
    }
    private static void checkDuplicateBonusNumber(List<Integer> winningNumbers, int num) {
        if(winningNumbers.contains(num)){
            OutputUtils.printBasicMessage(MessageType.ERROR_DUPLICATE_WINNING_INPUTS);
            throw new IllegalStateException();
        }
    }

    private static boolean isNumberOutOfBounds(int num){
        return num < MIN_AMOUNT || num > MAX_AMOUNT;
    }


}
