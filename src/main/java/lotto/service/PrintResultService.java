package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PrintResultService {
    private static final String RESULTPRINTMESSAGE = "당첨 통계\n---";
    private static final String RESULT_FIVE = "3개 일치 (5,000원) - ";
    private static final String RESULT_FOUR = "4개 일치 (50,000원) - ";
    private static final String RESULT_THREE =" 5개 일치 (1,500,000원) - ";
    private static final String RESULT_TWO = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String RESULT_ONE = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_SCORE = "총 수익률은 ";



    public void printResult(
            List<HashSet<Integer>> userNumbers,
            HashSet<Integer> lottoNumbers) {
        System.out.println(RESULTPRINTMESSAGE);
        HashMap<Integer,Integer> result = null;
    }


//    public HashMap<Integer,Integer> lotto(
//            List<HashSet<Integer>> userNumbers,
//            HashSet<Integer> lottoNumbers){
//        List<Integer> result = List.of(0,0,0,0,0,0,0);
//        for (HashSet<Integer> oneOfUserLottoNumbers: userNumbers) {
//            oneOfUserLottoNumbers.retainAll(lottoNumbers);
//            result.put(oneOfUserLottoNumbers.size(), result.get());
//        }
//    }








}
