package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.User;
import model.WinningNumber;
import validate.ErrorMessageenum;

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
                System.out.println(ErrorMessageenum.ERROR1.getMessage());
                throw new IllegalArgumentException();
            }
        }
        return winning_number;
    }


    public List<Lotto> makeLottoList(int price){
        List<Lotto> lottoList = new ArrayList<>();
        int lotto_count = price/1000;
        for(int i = 0; i<lotto_count;i++){
            lottoList.add(generateLottoNumber());
        }
        return lottoList;
    }

    public Lotto generateLottoNumber(){
        List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumber);

        Lotto lotto = new Lotto(lottoNumber);

        return lotto;
    }

    public Map<String,Integer> calculateRanking(Lotto lotto, WinningNumber winningNumber){
        Map<String, Integer> lottoResult = new HashMap<>();
        int count =0;
        lottoResult.put("bonus", 0);
        for(int num:winningNumber.getWinning_number()){
            if(lotto.getNumbers().contains(num)){
                count++;
            }
        }
        if (lotto.getNumbers().contains(winningNumber.getBonus())) {
            lottoResult.replace("bonus", 1);
        }
        lottoResult.put("count", count);
        return lottoResult;
    }

    public void awardLotto(Map<String, Integer> lottoResult, User user){
        if (lottoResult.get("count") == 3){
            user.checkRanking("fifth");
        }
        if(lottoResult.get("count") == 4){
            user.checkRanking("fourth");
        }
        if(lottoResult.get("count") == 5 && lottoResult.get("bonus") == 1){
            user.checkRanking("second");
        }else if(lottoResult.get("count") == 5){
            user.checkRanking("third");
        }
        if(lottoResult.get("count") == 6){
            user.checkRanking("first");
        }
    }

    public String rateReturn(User user){
        String rate = String.format("%.1f",(double) user.getMoney() / (double) user.getPrice() * 100);
        return rate;
    }

}
