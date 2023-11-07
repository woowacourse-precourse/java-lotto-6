package lotto.controller;

import lotto.Lotto;
import lotto.model.Place;
import lotto.model.WinLotto;
import lotto.model.WinLottoPlaceCount;

import java.util.List;

public class CountWinLotto {


    public WinLottoPlaceCount lottoPlaceCount(WinLotto winLotto, List<Lotto> myLottos){
        WinLottoPlaceCount winLottoPlaceCount = new WinLottoPlaceCount();
        for(Lotto myLotto : myLottos){
            Place place = eachLottoPlace(winLotto,myLotto);
            winLottoPlaceCount.plusWinLottoPlaceCount(place);
        }
        return winLottoPlaceCount;
    }

    private Place eachLottoPlace(WinLotto winLotto,Lotto myLotto){
        List<Lotto> secondPlaceLottos=winLotto.getSecondPlaceLottos();
        List<Integer> myLottoNumbers = myLotto.getNumbers();
        for(Lotto lotto: secondPlaceLottos){
            if(myLottoNumbers.containsAll(lotto.getNumbers())){
                return Place.SECOND_PLACE;
            }
        }
        int num=0;
        List<Integer> numbers=winLotto.getWinLottoNumbers();
        for(int i=0;i<6;i++){
            if(myLottoNumbers.contains(numbers.get(i))){
                num+=1;
            }
        }
        System.out.println("numbers+ = " + numbers +"num ="+num);
        return matchPlace(num);
    }

    private Place matchPlace(int num){
        if(num==6){
            return Place.FIRST_PLACE;
        }
        if(num==5){
            return Place.THIRD_PLACE;
        }
        if(num==4){
            return Place.FOURTH_PLACE;
        }
        if(num==3){
            return Place.FIFTH_PLACE;
        }
        return Place.NO_PLACE;
    }

}
