package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class refinedWinning {
    private static List<String> check_winning = new ArrayList<>();
    public static void Input_Winning(String winning){
        String[] divide_winning = winning.split(",");
        check_winning = new ArrayList<String>(Arrays.asList(divide_winning));
    }
}