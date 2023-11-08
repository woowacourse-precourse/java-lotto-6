package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import java.util.ArrayList;

public class Input {
    private final static String SET_PRICE = "구입금액을 입력해 주세요.";
    private final static String SET_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String SET_BONUS = "보너스 번호를 입력해 주세요.";
    private static List<Integer> list;

    public static String set_Price() {
        System.out.println(SET_PRICE);
        return Console.readLine();
    }

    public static List<Integer> set_Number() {
        System.out.println();
        System.out.println(SET_NUMBER);
        return numberList(Console.readLine());

    }

    public static int set_Bonus() {
        System.out.println();
        System.out.println(SET_BONUS);
        try {
            int b = Integer.parseInt(Console.readLine());
            if (list.contains(b)) {
                throw new IllegalArgumentException();
            }
            return b;
        } catch (IllegalArgumentException e) {
            ErrorMessage.duplicate_Error();
            return set_Bonus();
        }

    }

    public static List<Integer> numberList(String number) {
        try {
            String[] arr = number.split(",");
            if (arr.length != 6) {
                throw new IllegalArgumentException();
            }
            list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(String_To_Int(arr[i]));
            }
            return list;
        } catch (IllegalArgumentException e) {
            ErrorMessage.count_Error();
            System.out.println(SET_NUMBER);
            return numberList(Console.readLine());
        }
    }

    public static int String_To_Int(String str) throws IllegalArgumentException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ErrorMessage.number_Error();
            throw new IllegalArgumentException();
        }
    }

}
