package lotto;

import java.util.List;

public class DataOutput {
    public void printPurchaseLottoNumbers(List<Integer> lottoNumbers){
        String toPrint = "[" + lottoNumbers.get(0);

        for(int i = 1; i < lottoNumbers.size(); i++){
            toPrint = toPrint + ", " + lottoNumbers.get(i);
        }
        toPrint += "]";

        System.out.println(toPrint);
    }

    public void printProgressMessage(Progress progressMessage){
        System.out.println(progressMessage.getMessage());
    }
}
