package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {
    public List<Integer> makeWinningNumber(String number){
        List<Integer> winning_number = new ArrayList<>();
        String[] numberList = number.split(",");

        for (String num : numberList) {
            try {
                winning_number.add(Integer.parseInt(num));
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        return winning_number;
    }
    public Lotto generateLottoNumber(){
        Set<Integer> lottoNumberSet = new HashSet<>();

        while (lottoNumberSet.size() <6){
            lottoNumberSet.add(Randoms.pickNumberInRange(1, 45));
        }
        ArrayList<Integer> lottoNumber = new ArrayList<>(lottoNumberSet);
        Collections.sort(lottoNumber);

        Lotto lotto = new Lotto(lottoNumber);

        return lotto;
    }

    public List<Lotto> makeLottoList(int price){
        List<Lotto> lottoList = new ArrayList<>();
        int lotto_count = price/1000;
        for(int i = 0; i<lotto_count;i++){
            lottoList.add(generateLottoNumber());
        }
        return lottoList;
    }
}
