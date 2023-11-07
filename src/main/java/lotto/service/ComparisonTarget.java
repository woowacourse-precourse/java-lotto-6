package lotto.controller;

import lotto.generator.ClientLottoNumber;

import java.util.List;

public class ComparisonTarget {
    public List<Integer> list1;
    public List<Integer> List_Target(){
        ClientLottoNumber clientLottoNumber=new ClientLottoNumber();
        int list_size=clientLottoNumber.LottoNumberList.size();
        list1 =clientLottoNumber.LottoNumberList.get(0);
        return list1;
    }
}
