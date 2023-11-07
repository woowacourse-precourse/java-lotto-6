package lotto.view;

import lotto.Lotto;
import lotto.OutputMessage;

import java.util.List;

public class OutputView {

    public void blank(){
        System.out.println();
    }

    public void MyLottos(List<Lotto> Lottos,int gameCount){
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
    }

}
