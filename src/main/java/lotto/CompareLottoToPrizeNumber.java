package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.HitLottoNumber.hitLottoNumber;

public class CompareLottoToPrizeNumber {
    public static HashMap<Integer, Integer> winLottoToPrizeNumber(ArrayList<Integer> prizeNumberArray, ArrayList<List<Integer>> totalLotto, int bonusNumber){ // 당첨번호와 일치하는 로또의 개수를 체크한다
        HashMap<Integer, Integer> winHashTable = new HashMap<>();
        for(int i=0; i <= 5; i++){
            winHashTable.put(i, 0); // key 0부터 5의 value는 0으로 초기화
        }

        for(List<Integer> lotto : totalLotto){ // 로또를 순회하면서
            int winNumber = hitLottoNumber(lotto, prizeNumberArray, bonusNumber); // 로또와 당첨 번호를 비교하고 등수를 리턴
            winHashTable.put(winNumber, winHashTable.get(winNumber) + 1); // 등수에 해당하는 key의 value를 +1
        }

        return winHashTable;
    }
    public static void printPrizeText(HashMap<Integer, Integer> winHashTable){ // 당첨 결과를 출력한다
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winHashTable.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winHashTable.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winHashTable.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winHashTable.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winHashTable.get(1) + "개");
    }
}
