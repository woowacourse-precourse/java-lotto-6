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

    public void resultPrint(int[] rank, float rate){
        System.out.println("당첨 통계");
        System.out.println("---");

        String[] str = {
                "3개 일치 (5,000원) - ",
                "4개 일치 (50,000원) - ",
                "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
                "6개 일치 (2,000,000,000원) - "
        };

        // 5, 4, 3, 2, 1등(3개, 4개, 5개, 5개 보너스일치, 6개 일치)
        for(int i = 0; i < rank.length; i++)
            System.out.println(str[i] + rank[i] + "개");

        String result_str = "총 수익률은 " + String.format("%.1f", rate);
        System.out.print(result_str);
        System.out.print("%입니다.");
    }

}
