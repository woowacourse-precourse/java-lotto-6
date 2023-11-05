package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchedNumbers {
    private final ArrayList<String> LOTTO_MATCHED_COUNT_LIST;
    private int lottoMatchedCount;
    public MatchedNumbers(ArrayList<List<String>> myLotto, ArrayList<String> winLotto){
        this.LOTTO_MATCHED_COUNT_LIST = matchedNumberCounterAll(myLotto,winLotto);
    }

    public ArrayList<String> getLOTTO_MATCHED_COUNT_LIST(){
        return LOTTO_MATCHED_COUNT_LIST;
    }
    private ArrayList<String> matchedNumberCounterAll(ArrayList<List<String>> myLotto, ArrayList<String> winLotto){
        ArrayList<String> matchedLottos = new ArrayList<>();
        for(List<String> lotto : myLotto){
            matchedNumberCountEach(lotto,winLotto);
            matchedLottos.add(String.valueOf(lottoMatchedCount));
        }
        return matchedLottos;
    }


    private void matchedNumberCountEach(List<String> myLotto, ArrayList<String> winLotto){
        HashSet<String> myHash = new HashSet<>(myLotto);
        HashSet<String> winHash = new HashSet<>(winLotto);
        myHash.retainAll(winHash);
        lottoMatchedCount =  myHash.size();
    }
}
