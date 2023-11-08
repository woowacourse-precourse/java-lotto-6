package lotto.view;


import java.util.Map.Entry;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.lottoService;
public class messagePrinter {

    public static void printPurchaseAmountInstruction(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseAmount(int purchasedLottos){
        System.out.println(purchasedLottos + "개를 구매했습니다.");
    }

    public static void printWinningNumInstruction(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumInstruction(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPurchasedLottos(){
        List<Lotto> lottos = lottoService.getLottos();

        for(int i=0;i<lottos.size();i++){
            Collections.sort(lottos.get(i).getNumbers());
            System.out.println(lottos.get(i).getNumbers());
        }
    }
    public static void printLottoResults(LinkedHashMap<Rank, Integer> lottoHashMap){
        for(Entry<Rank,Integer> hash : lottoHashMap.entrySet()){
            if(hash.getKey().equals(Rank.NONE)){ continue; }
            System.out.println(hash.getKey().getResult()+" - "+hash.getValue()+"개");
        }
    }

    public static void printProfitRate(){
        double profitRate = lottoService.getProfitRate();
        System.out.println(String.format("총 수익률은 %.1f%%입니다.",profitRate));
    }









}
