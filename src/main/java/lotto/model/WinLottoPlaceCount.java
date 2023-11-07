package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinLottoPlaceCount {

    List<Integer> winLottoPlaceCount;

    public WinLottoPlaceCount(){
        winLottoPlaceCount=new ArrayList<>();
        winLottoPlaceCount.add(Place.NO_PLACE.getValue(), 0);
        winLottoPlaceCount.add(Place.FIRST_PLACE.getValue(),0);
        winLottoPlaceCount.add(Place.SECOND_PLACE.getValue(), 0);
        winLottoPlaceCount.add(Place.THIRD_PLACE.getValue(),0);
        winLottoPlaceCount.add(Place.FOURTH_PLACE.getValue(),0);
        winLottoPlaceCount.add(Place.FIFTH_PLACE.getValue(), 0);
    }

    public List<Integer> getWinLottoPlaceCount(){
        return this.winLottoPlaceCount;
    }

    public void plusWinLottoPlaceCount(Place place){
        int placeCount=winLottoPlaceCount.get(place.getValue())+1;
        winLottoPlaceCount.set(place.getValue(),placeCount);
    }

}
