package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static void buyLotto(int price){
        int lottoNum = price / 1000;
        ArrayList<List<Integer>> lottos = new ArrayList<>();

        for(int i = 0;i < lottoNum; i++){
            lottos.add(LottoGenerate.generate());
        }
    }



}
