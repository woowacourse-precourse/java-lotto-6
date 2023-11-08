package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {

    public LottoController(){
    }

    void play(){
        int LottoNum = moneyInput();
        List<Lotto> LottoList = buyLotto(LottoNum);
        List<Integer> WinningNum = winningNumInput();
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
            System.out.println(LottoList.get(i).getNumbers());
        }
        return LottoList;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int Money = Integer.parseInt(readLine());
        int LottoNum = Money / 1000;
        System.out.println(LottoNum + "개를 구매했습니다.");
        return LottoNum;
    }

    private void bonusNumInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNum = Integer.parseInt(readLine());
    }


    private List<Integer> winningNumInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> list = Arrays.stream(readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return list;
    }


}
