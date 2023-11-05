package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchedNumbers {

    /*
    private void matchedNumberCounter(ArrayList<List<String>> winLottoNumber, ArrayList<String> myLottoNumber){
        for(List<String> winNumbers : winLottoNumber){
            if(winNumbers.stream().anyMatch(lotto -> lo)){

            }
        }

    }

     */

    public static int matchedNumberFinder(List<String> winLottoNumber, ArrayList<String> myLottoNumber){
        HashSet<String> winHash = new HashSet<>(winLottoNumber);
        HashSet<String> myHash = new HashSet<>(myLottoNumber);
        winHash.retainAll(myHash);
        return myHash.size() - winHash.size();
    }
}
