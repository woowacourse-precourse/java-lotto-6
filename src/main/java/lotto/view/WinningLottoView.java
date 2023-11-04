package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.consts.ErrorMessage;
import lotto.consts.MachineMessage;
import lotto.utils.Convertor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoView {
    private final static String R_RANGE = "^(?:4[0-5]|[1-3][0-9]|[1-9])$";
    private final static int COUNT = 6;
    public static List<Integer> publish() {
        String input;

        do {
            System.out.println(MachineMessage.MACHINE_MESSAGE_WINNING_LOTTO.getMessage());
            input = Console.readLine().trim();
        } while (!isErrorOccurred(input));

        return Convertor.convertStringToList(input).stream().map(Integer::parseInt).toList();
    }

    public static boolean isErrorOccurred(String input) {
        try {
            validateNumbersInArray(input);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public static void validateNumbersInArray(String input) throws IllegalArgumentException {
        List<String> inputs = Convertor.convertStringToList(input);
        Set<String> inputDeduplication = new HashSet<>(Convertor.convertStringToList(input));

        if(inputs.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
        }

        if(inputDeduplication.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_DUPLICATED_EXISTENCE.getMessage());
        }

        for(String i : inputs) {
            validateLottoNumber(i);
        }
    }

    public static void validateLottoNumber(String input) throws IllegalArgumentException {
        if(!input.matches(R_RANGE)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_LOTTO_NUMBER.getMessage());
        }
    }
}
