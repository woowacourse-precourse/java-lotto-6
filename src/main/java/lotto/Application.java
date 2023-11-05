package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BuyPrice;
import lotto.domain.UserNumber;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserNumber userNumber = new UserNumber();
        List<Integer> a = new ArrayList<>();
        a = userNumber.lottonumber(a);
        System.out.println(a);
    }
}