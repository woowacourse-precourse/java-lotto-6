package Model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    public static List<Lotto> lottoList=new ArrayList<>();
    private static Integer lottoNum;
    public PurchaseLotto(Integer purchaseAmount){
        lottoNum=purchaseAmount/1000;
        System.out.println(lottoNum+"개를 구매했습니다");
        makeLottoList(lottoNum);
        printAllLotto();
    }
    private void makeLottoList(Integer num){
        for(int i=0;i<num;i++){
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }
    private void printAllLotto(){
        for(Lotto aLotto : lottoList){
            aLotto.printLotto();
        }
    }


}
