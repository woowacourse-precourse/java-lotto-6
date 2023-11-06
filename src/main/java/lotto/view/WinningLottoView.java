package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.consts.ErrorMessage;
import lotto.consts.MachineMessage;
import lotto.utils.Convertor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoView {
    private final static String R_RANGE = "^(?:4[0-5]|[1-3][0-9]|[1-9])$";
    private final static int COUNT_NO_BONUS = 6;
    private final static int COUNT_WITH_BONUS = 7;

    public static List<Integer> publishLotto() {
        String input;

        do {
            System.out.println(MachineMessage.MACHINE_MESSAGE_WINNING_LOTTO.getMessage());
            input = Console.readLine().trim();
        } while (!isErrorOccurredInLotto(input));

        return Convertor.convertStringToList(input).stream().map(Integer::parseInt).toList();
    }

    public static int publishBonus(List<Integer> lottos) {
        String input;

        do {
            System.out.println(MachineMessage.MACHINE_MESSAGE_BONUS.getMessage());
            input = Console.readLine().trim();
        } while (!isErrorOccurredInBonus(lottos, input));

        return Integer.parseInt(input);
    }

    public static boolean isErrorOccurredInLotto(String input) {
        try {
            validateNumbersInArray(input);
            validateDuplicate(Convertor.convertStringToList(input), COUNT_NO_BONUS);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            System.out.println();
            return false;
        }
        return true;
    }

    public static boolean isErrorOccurredInBonus(List<Integer> lottos, String input) {
        try {
            List<String> lottoWithBonus = new ArrayList<>(lottos.stream().map(i -> Integer.toString(i)).toList());
            lottoWithBonus.add(input);

            validateDuplicate(lottoWithBonus, COUNT_WITH_BONUS);
            validateLottoNumber(input);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }


    public static void validateDuplicate(List<String> inputs, int range) throws IllegalArgumentException {
        Set<String> inputDeduplication = new HashSet<>(inputs);

        if(inputDeduplication.size() != range) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_DUPLICATED_EXISTENCE.getMessage());
        }
    }

    public static void validateNumbersInArray(String input) throws IllegalArgumentException {
        List<String> inputs = Convertor.convertStringToList(input);

        if(inputs.size() != COUNT_NO_BONUS) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_NOT_ENOUGH_LOTTO_NUMBER.getMessage());
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
