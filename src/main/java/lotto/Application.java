package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BuyPrice;
import lotto.domain.UserNumber;
import lotto.domain.WinNumber;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        WinNumber winNumber = new WinNumber();
        num = winNumber.win();
        System.out.println(num);
    }
}