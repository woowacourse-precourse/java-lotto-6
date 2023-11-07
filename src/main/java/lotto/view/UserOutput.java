package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class UserOutput {
    public void outputCount(int count){
        System.out.println("");
        System.out.println(count+"개를 구매하였습니다.");
    }
    public void outputGenerateNumber(List<Lotto> lottoInventory){
        for (Lotto lotto : lottoInventory){
            System.out.println(lotto);
        }
        System.out.println("");
    }
}
