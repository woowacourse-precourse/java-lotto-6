package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class UserOutput {
    public void outputCount(int count){
        System.out.println("");
        System.out.println(count+"개를 구매했습니다.");
    }

    public void outputGenerateNumber(List<Lotto> lottoInventory){

        for (Lotto lotto : lottoInventory){
            System.out.println(lotto);
        }
        System.out.println("");
    }
    public void outputResult(Map<Rank, Integer> result){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        List<Rank> keySet = new ArrayList<>(result.keySet());
        Collections.sort(keySet, Comparator.reverseOrder());

        System.out.println("당첨 통계");
        System.out.println("---");
        for(Rank key: keySet){
            String decimal = decimalFormat.format(key.getPrize());
            System.out.println(key.getState()+" ("
                    + decimal+"원) - "+ result.get(key)+"개");
        }
    }
}
