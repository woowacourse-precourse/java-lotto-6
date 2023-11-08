package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;


public class Input_View {
    private static final String input_lotto_bonus_number = "보너스 번호를 입력해 주세요.";

    private static List<Integer> winning_numbers_List;

    private static final String input_lotto_purchase_amount_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String input_lotto_winning_numbers_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String input_lotto_bonus_number_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static String input_lotto_purchase_amount() {
        System.out.println(input_lotto_purchase_amount_MESSAGE);
        return Console.readLine();
    }

    public static List<Integer> input_lotto_winning_numbers() {
        System.out.println(input_lotto_winning_numbers_MESSAGE);
        return winning_numbers_List_temp(Console.readLine());
    }

    private static int parse_Int(String input_number) {
        try {
            return Integer.parseInt(input_number);
        } catch (NumberFormatException e) {
            Exception_Message.exception_check_input_equals_integer();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> winning_numbers_List_temp(String winning_number) {
        String[] res = winning_number.split(",");
        winning_numbers_List = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            winning_numbers_List.add(parse_Int(res[i]));
        }
        return winning_numbers_List;
    }

    public static int input_lotto_bonus_number() {
        System.out.println(input_lotto_bonus_number_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
