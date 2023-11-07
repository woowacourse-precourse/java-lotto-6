package service;

import java.util.ArrayList;
import java.util.List;
import util.EqualNumberAccordRank;
import util.LottoRankNumber;
import util.LottoWinningPrice;

public class EnumToList {

    public static List<Integer> equalNumberAccordRankToList(){
        List<Integer> enumTolist = new ArrayList<>();

        for(EqualNumberAccordRank value : EqualNumberAccordRank.values()){
            enumTolist.add(value.get());
        }
        return enumTolist;
    }

    public static List<Integer> lottoWiningPriceToList(){
        List<Integer> enumTolist = new ArrayList<>();

        for(LottoWinningPrice value : LottoWinningPrice.values()){
            enumTolist.add(value.get());
        }
        return enumTolist;
    }

    public static List<Integer> lottoRankNumberToList() {
        List<Integer> enumTolist = new ArrayList<>();

        for(LottoRankNumber value : LottoRankNumber.values()){
            enumTolist.add(value.get());
        }
        return enumTolist;
    }
}
