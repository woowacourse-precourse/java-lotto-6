package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    public List<Integer> makeWinningNumber(String number){
        List<Integer> winning_number = new ArrayList<>();
        String[] numberList = number.split(",");

        for (String num : numberList) {
            winning_number.add(Integer.parseInt(num));
        }

        return winning_number;
    }
    public List<Integer> generateLottoNumber(){
        Set<Integer> lottoNumberSet = new HashSet<>();
        while (lottoNumberSet.size() <6){
            lottoNumberSet.add(Randoms.pickNumberInRange(1, 45));
        }
        ArrayList<Integer> lottoNumberList = new ArrayList<>(lottoNumberSet);
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
