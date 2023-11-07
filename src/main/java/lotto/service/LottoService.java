package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Constant.*;

public class LottoService {

    public int convertToTimes(String inputMoney) {
        int money = validateMoney(inputMoney);
        if (money % 1000 == 0 )
            return money / 1000;
        throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }


    public int validateMoney(String inputMoney){
        String REGEX = "[0-9]+";
        if(!inputMoney.matches(REGEX) || inputMoney.charAt(0) == '0')
            throw new IllegalArgumentException("[ERROR] 금액을 입력해 주세요.");
        return Integer.parseInt(inputMoney);
    }

    public List<Lotto> createLottoes(int times) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            result.add(createLotto());
        }
        return result;
    }

    public Lotto createLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }

    public Lotto convertToLotto(String inputWinningNum){
        List<String> before = Arrays.stream(inputWinningNum.split(",")).toList();

        validateUserWinningNum(before);

        List<Integer> winningNums = before.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return new Lotto(winningNums);
    }

    public void validateUserWinningNum(List<String> numbers){
        //6개 입력했는지
        if(numbers.size() != MAX_LOTTOES_SIZE)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력해 주세요.");

        //중복 체크
        if(numbers.stream().distinct().count() != MAX_LOTTOES_SIZE)
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");

        //1부터 45인지 확인
        for(String num : numbers){
            if(validateNum(num)) continue;
        }
    }

    public int validateUserBonusNum(Lotto winningNum, String bonusNum){
        if(validateNum(bonusNum) && !winningNum.getNumbers().contains(Integer.parseInt(bonusNum))){ //숫자인지 확인
           return Integer.parseInt(bonusNum);
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 번호는 입력할 수 없습니다.");
    }

    public boolean validateNum(String inputNum){ //숫자 하나 확인
        String REGEX = "[0-9]+";
        if(inputNum.matches(REGEX) && (MIN <= Integer.parseInt(inputNum) && Integer.parseInt(inputNum) <= MAX))
            return true;
        throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45까지 입력해 주세요.");
    }

    public HashMap<Integer, Integer> matchNums(List<Lotto> lottoes, Lotto userWinningNum, Integer bonusNum){
        // 3, 4, 5, 5보너스, 6 => 3, 4, 5, 6, 7
        HashMap<Integer, Integer> matchCount = new HashMap<>();
        matchCount.put(3, 0);
        matchCount.put(4, 0);
        matchCount.put(5, 0);
        matchCount.put(6, 0);
        matchCount.put(7, 0);


        for(Lotto lotto : lottoes){
            //맞는 개수 카운트
            int cnt = 0;
            int bonusCnt = 0;
            for(Integer i : userWinningNum.getNumbers()){
                if(lotto.getNumbers().contains(i)){
                    cnt++;
                }
            }
            if(lotto.getNumbers().contains(bonusNum))
                bonusCnt++;

            //맞춘 개수에 따라 체크
            if(cnt == 3) {
                matchCount.replace(3, matchCount.get(3) + 1);
            } else if (cnt == 4) {
                matchCount.replace(4, matchCount.get(4) + 1);
            } else if (cnt == 5 && bonusCnt == 0) {
                matchCount.replace(5, matchCount.get(5) + 1);
            } else if (cnt == 5 && bonusCnt == 1) {
                matchCount.replace(6, matchCount.get(6) + 1);
            } else if (cnt == 6) {
                matchCount.replace(7, matchCount.get(7) + 1);
            }
        }

        return matchCount;
    }

    public double calculateRateOfReturn(int money, HashMap<Integer, Integer> matchCount){ //구매 돈, 맞은 개수 카운트
        double rateOfResult = 0.0;

        double total = matchCount.get(3)* THREE_MATCH_MONEY
                + matchCount.get(4) * FOUR_MATCH_MONEY
                + matchCount.get(5) * FIVE_MATCH_MONEY
                + matchCount.get(6) * FIVE_BONUS_MATCH_MONEY
                + matchCount.get(7) * SIX_MATCH_MONEY;

        rateOfResult = total / (double) money * 100;
        rateOfResult = Math.round(rateOfResult*100)/100.0;

        return rateOfResult;
    }




}