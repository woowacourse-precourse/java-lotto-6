package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputController {

    public int getMoney(){
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public Lotto inputNumbers(){
        List<Integer> numbers = new ArrayList<>();

        String[] input = Console.readLine().split(",");
        for(String s : input)
            numbers.add(Integer.parseInt(s));

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }
}
