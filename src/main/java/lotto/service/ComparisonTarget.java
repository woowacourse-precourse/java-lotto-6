package lotto.service;

import lotto.generator.ClientLottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ComparisonTarget {
    public List<Integer> List_Target() {
        ClientLottoNumber clientLottoNumber =new ClientLottoNumber();
        int list_size = clientLottoNumber.LottoNumberList.size();
        List<Integer> list1 = new ArrayList<>();
        System.out.println(list_size);
        for (int i = 0; i < list_size; i++) {
            System.out.println(clientLottoNumber.LottoNumberList.get(i));
        }
        return list1;
    }
}
