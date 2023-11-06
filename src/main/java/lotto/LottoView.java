package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoView {

    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }
    public Lotto inputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] sNumbers = Console.readLine().split(",");
        List<Integer> winningLottoNumber=new ArrayList<>();
        for(int i=0;i<sNumbers.length;i++){
            winningLottoNumber.add(Integer.parseInt(sNumbers[i]));
        }
        return new Lotto(winningLottoNumber);
    }
    public void showLottos(LottoRepository lottoRepository){
        List<Lotto> lottos = lottoRepository.getLottos();
        lottos.forEach(lotto->System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }
}
