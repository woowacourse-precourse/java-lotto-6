package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {

    public LottoController(){
    }

    void play(){
        int LottoNum = moneyInput();
        List<Lotto> LottoList = buyLotto(LottoNum);
        winningNumInput();
        bonusNumInput();
    }

    private List<Lotto> buyLotto(int lottoNum) {
        List<Lotto> LottoList = new ArrayList<>();
        for(int i=0; i<lottoNum; i++){
            List<Integer> list = makeRandomNum();
            Lotto lotto = new Lotto(list);
            LottoList.add(lotto);
        }
        for(int i=0; i<LottoList.size(); i++){
            System.out.println(LottoList.get(i).numbers);
        }
        return LottoList;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private int moneyInput() {
        System.out.print("Money : ");
        int Money = Integer.parseInt(readLine());
        int LottoNum = Money / 1000;
        System.out.println("LottoNum = " + LottoNum);
        return LottoNum;
    }

    private void bonusNumInput() {
        System.out.print("BonusNum : ");
        int BonusNum = Integer.parseInt(readLine());
        System.out.println("BonusNum = " + BonusNum);
    }


    private void winningNumInput(){
        System.out.print("List : ");
        List<Integer> list = Arrays.stream(readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        System.out.println("List = " + list);
        Lotto lotto = new Lotto(list);
    }


}
