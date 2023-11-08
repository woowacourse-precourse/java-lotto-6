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
    }

    private void MoneyInput() {
        int Money = Integer.parseInt(readLine());
        System.out.println(Money);
    }

    private void LottoNumInput(){
        List<Integer> list = Arrays.stream(readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        System.out.println(list);
        Lotto lotto = new Lotto(list);
    }
}
