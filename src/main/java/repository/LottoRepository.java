package repository;

import domain.Lotto;
import domain.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRepository {
    public List<Lotto> lottoList;
    public LottoRepository(int size){
        lottoList = new ArrayList<>(size);
    }

    public void add(Lotto lotto){
        lottoList.add(lotto);
    }

    public List<Lotto> findAll(){
        return lottoList;
    }
    public int size(){
        return lottoList.size();
    }
    public void clear(){
        lottoList.clear();
    }

    public void updateAllLottoPlace(Lotto winningNumbers,int bounsNumber){
        for(Lotto lotto : lottoList){
            lotto.whichPlace(winningNumbers,bounsNumber);
        }
    }

    public Map<Place,Integer> findAllPlace(){
        Map<Place,Integer> numberOfPlaceMap = new HashMap<>(){{
            put(Place.FIRST,0);
            put(Place.SECOND,0);
            put(Place.THIRD,0);
            put(Place.FORTH,0);
            put(Place.FIFTH,0);
            put(Place.NONE,0);
        }};

        for(Lotto lotto : lottoList){
            int numberOfPlace = numberOfPlaceMap.get(lotto.getPlace());
            numberOfPlaceMap.put(lotto.getPlace(),numberOfPlace+1);
        }

        return numberOfPlaceMap;
    }

}
