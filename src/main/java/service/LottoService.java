package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {
    public List<Integer> generateLottoNumbers(){
        Set<Integer> lottoNumberSet = new HashSet<>();
        while (lottoNumberSet.size() <6){
            lottoNumberSet.add(Randoms.pickNumberInRange(1, 45));
        }
        ArrayList<Integer> lottoNumberList = new ArrayList<>(lottoNumberSet);
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
