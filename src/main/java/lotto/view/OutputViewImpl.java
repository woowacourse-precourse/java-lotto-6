package lotto.view;

import lotto.Lotto;
import lotto.message.OutputMessage;
import lotto.message.Place;

import java.util.List;

public class OutputViewImpl implements OutputView {

    public void blank(){
        System.out.println();
    }

    public void myLottos(List<Lotto> Lottos, int gameCount){
        blank();
        System.out.println(gameCount+OutputMessage.OUTPUT_BUY_MESSAGE.toString());
        for(Lotto lotto:Lottos){
            StringBuilder concatenatedNums = new StringBuilder();

            for (int num : lotto.getNumbers()) {
                concatenatedNums.append(num);
                concatenatedNums.append(", ");
            }
            String result = concatenatedNums.substring(0, concatenatedNums.length() - 2);

            System.out.println("["+result+"]");
        }
        blank();
    }

    public void lottoResult(List<Integer> winLottoPlaceCount,double rateMoney){
        blank();
        System.out.println("당첨 통계\n" + "---");
        for(int i=1;i<6;i++){
            System.out.println(Place.getStringFromValue(i)+winLottoPlaceCount.get(i)+"개");
        }
        System.out.println("총 수익률은 "+String.format("%.1f", rateMoney)+"%입니다.");
    }

}
