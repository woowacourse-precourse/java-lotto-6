package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {

    public LottoController(){
    }

    void play(){
        MoneyInput();
        LottoNumInput();
        BonusNumInput();
    }

    private void MoneyInput() {
        System.out.print("Money : ");
        int Money = Integer.parseInt(readLine());
        System.out.println("Money = " + Money);
    }

    private void BonusNumInput() {
        System.out.print("BonusNum : ");
        int BonusNum = Integer.parseInt(readLine());
        System.out.println("BonusNum = " + BonusNum);
    }


    private void LottoNumInput(){
        System.out.print("List : ");
        List<Integer> list = Arrays.stream(readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        System.out.println("List = " + list);
        Lotto lotto = new Lotto(list);
    }


}
