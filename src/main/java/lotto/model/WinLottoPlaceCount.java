package lotto.model;

import lotto.message.Place;

import java.util.ArrayList;
import java.util.List;

public class WinLottoPlaceCount {

    List<Integer> winLottoPlaceCount;

    public WinLottoPlaceCount(){
        winLottoPlaceCount=new ArrayList<>();
        for(int i=0;i<6;i++){
            winLottoPlaceCount.add(0);
        }
    }

    public List<Integer> getWinLottoPlaceCount(){
        return this.winLottoPlaceCount;
    }

    public void plusWinLottoPlaceCount(Place place){
        int placeCount=winLottoPlaceCount.get(place.getValue())+1;
        winLottoPlaceCount.set(place.getValue(),placeCount);
    }

}
