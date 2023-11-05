package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchedNumbers {
    private final ArrayList<String> LOTTO_MATCHED_COUNT_LIST;
    public MatchedNumbers(ArrayList<List<String>> winLottoNumber, ArrayList<String> myLottoNumber){
        this.LOTTO_MATCHED_COUNT_LIST = matchedNumberCounterAll(winLottoNumber,myLottoNumber);
    }


    private ArrayList<String> matchedNumberCounterAll(ArrayList<List<String>> winLottoNumber, ArrayList<String> myLottoNumber){
        ArrayList<String> matchedLottos = new ArrayList<>();
        for(List<String> winLotto : winLottoNumber){
            matchedLottos.add(String.valueOf(matchedNumberCountEach(winLotto,myLottoNumber)));
        }
        return matchedLottos;
    }



    public static int matchedNumberCountEach(List<String> winLottoNumber, ArrayList<String> myLottoNumber){
        HashSet<String> winHash = new HashSet<>(winLottoNumber);
        HashSet<String> myHash = new HashSet<>(myLottoNumber);
        winHash.retainAll(myHash);
        return myHash.size() - winHash.size();
    }
}
