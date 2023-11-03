package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Lottos;

import java.util.Iterator;
import java.util.List;

public class PrintView {

    public void inputMoneyPrint(){
        System.out.println("구입금액을 입력해주세요.");
    }

    public void generatedLottosPrint(Lottos lottos){
        List<Lotto> list = lottos.getLottos();
        Iterator<Lotto> it = list.iterator();

        System.out.println(list.size() + "개를 구매했습니다.");

        while(it.hasNext()){
            Lotto lotto = it.next();
            List<Integer> numbers = lotto.getNumbers();
            Iterator num_it = numbers.iterator();
            System.out.print("[" + num_it.next());
            while(num_it.hasNext())
                System.out.print(", " + num_it.next());
            System.out.println("]");
        }
        System.out.println("");
    }

    public void inputNumbersPrint(){
        System.out.println("당첨번호를 입력해주세요");
    }

    public void inputBonusNumberPrint(){
        System.out.println("보너스 번호를 입력해주세요");
    }

    public void resultPrint(){

    }

}
