package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinNumber {
    static public List<Integer> win() {
        List<Integer> winnum = new ArrayList<>();
        String input = Console.readLine();
        String[] number = input.split(",");
        for (int i = 0; i < number.length; i++) {
            winnum.add(Integer.parseInt(number[i]));
        }
        return winnum;
    }
}