package lotto.controller;

import lotto.Lotto;
import lotto.model.GameMoney;
import lotto.message.Place;
import lotto.model.WinLotto;
import lotto.model.WinLottoPlaceCount;

import java.util.List;

public class CountWinLottoImpl implements CountWinLotto{

    public double getRateMoney(WinLottoPlaceCount winLottoPlaceCount, GameMoney gameMoney){
        List<Integer> prizeMoneyInfo = List.of(0,5000,50000,1500000,30000000,2000000000);
        long prizeMoney=0;
        List<Integer> place = winLottoPlaceCount.getWinLottoPlaceCount();
        for(int i=0;i<6;i++){
            prizeMoney+=place.get(i)*prizeMoneyInfo.get(i);
        }

        double rate=(double)prizeMoney/gameMoney.getMoney()*100.0;

        return rate;
    }


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
