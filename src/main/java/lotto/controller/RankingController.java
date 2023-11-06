package lotto.controller;

import lotto.generator.ClientLottoNumber;
import lotto.io.LottoNumberReader;

import java.util.List;

public class RankingController {
    public List<Integer> list1;
    public List<Integer> Ranking(){
        ClientLottoNumber clientLottoNumber=new ClientLottoNumber();
        int list_size=clientLottoNumber.LottoNumberList.size();
        for(int i=0;i<list_size;i++){
            list1 =clientLottoNumber.LottoNumberList.get(i);
        }
        return list1;
    }
}
