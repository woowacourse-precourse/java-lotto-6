package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static constants.Constant.*;
import static view.InputService.*;
import static view.OutputService.*;

public class LottoManager {

    public void run(){

        //로또 구매 입력 및 검증
        String priceString = inputPurchasePrice();
        validateNumber(priceString);
        Integer priceInteger = Integer.parseInt(priceString);
        validateValuePrice(priceInteger);

        //로또 구매 개수 계산
        Integer lottoCount = calculateLottoCount(priceInteger);

        List<Lotto>lottoList = new ArrayList<>();
        for(int i=0;i<lottoCount;i++){
            List<Integer> numbers = generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        printGeneratedLotto(lottoCount, lottoList);

        String winningNumberString = inputWinningNumber();
        validateTypeNumeric(winningNumberString);
        List<Integer>winningNumberList = convertToList(winningNumberString);
        Lotto winningNumber = new Lotto(winningNumberList);

        String bonusNumberString = inputBonusNumber();
        validateTypeNumeric(bonusNumberString);
        Integer bonusNumberInteger = Integer.parseInt(bonusNumberString);
        validateRangeNumber(bonusNumberInteger);
        HashMap<String, Integer> stat = calculateStat(lottoList, winningNumber, bonusNumberInteger);
        printLottoStat(stat);
        Float profitRate = calculateProfit(stat, priceInteger);
        printProfit(profitRate);
    }

    public Integer calculateSum(HashMap<String, Integer> stat){
        Integer sumLotto = 0;
        for(String key : stat.keySet()){
            if(Objects.equals(key, "3")){
                sumLotto += stat.get(key)*HIT_THREE_PRICE;
            }
            else if(Objects.equals(key, "4")){
                sumLotto += stat.get(key)*HIT_FOUR_PRICE;
            }
            else if(Objects.equals(key, "5")){
                sumLotto += stat.get(key)*HIT_FIVE_PRICE;
            }
            else if(Objects.equals(key, "5+")){
                sumLotto += stat.get(key)*HIT_FIVE_BONUS_PRICE;
            }
            else if(Objects.equals(key, "6")){
                sumLotto += stat.get(key)*HIT_SIX_PRICE;
            }
        }
        return sumLotto;
    }
    public Float calculateProfit(HashMap<String, Integer> stat, Integer price){
        Integer sumLotto = calculateSum(stat);
        return (float)sumLotto/price*HUNDRED;
    }

    public HashMap<String, Integer> calculateStat(
            List<Lotto> lottoList, Lotto winningNumber, Integer bonusNumber){

        HashMap<String,Integer> result = new HashMap<>();
        result.put("3",0);
        result.put("4",0);
        result.put("5",0);
        result.put("5+",0);
        result.put("6",0);

        for(int i=0;i<lottoList.size();i++){
            Lotto lotto = lottoList.get(i);
            String maximumHitCount = findMaxHit(lotto, winningNumber, bonusNumber);
            if(maximumHitCount.charAt(0)<'3')
                continue;
            result.put(maximumHitCount, result.get(maximumHitCount)+1);
        }
        return result;

    }

    public String findMaxHit(Lotto lotto, Lotto winningNumber, Integer bonusNumber){

        boolean bonusFlag = false;
        Integer hitCount = 0;

        for(int i=0; i<Lotto_LENGTH;i++){
            boolean matchFlag = false;
            int winningNum = winningNumber.getNumber(i);

            for(int j=0;j<Lotto_LENGTH;j++){
                int lottoNum = lotto.getNumber(j);
                if(lottoNum==winningNum)
                {
                    matchFlag=true;
                }
                if(lottoNum==bonusNumber)
                    bonusFlag=true;
            }
            if(matchFlag)
                hitCount++;
        }


        if(bonusFlag&&hitCount==5)
            return "5+";
        else{
            return String.valueOf(hitCount);
        }

    }

    public List<Integer>convertToList(String input){
        List<Integer>list = new ArrayList<>();
        for(String s : input.split(SEP_COMMA)){
            Integer value = Integer.parseInt(s);
            validateRangeNumber(value);
            list.add(value);
        }
        return list;
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                Lotto_BEGIN_RANGE, Lotto_END_RANGE, Lotto_LENGTH);
    }

    public Integer calculateLottoCount(Integer priceInt){
        return priceInt/LOTTO_PRICE;
    }

    public void validateRangeNumber(Integer number){
        if(number<Lotto_BEGIN_RANGE || number>Lotto_END_RANGE){
            throw new IllegalArgumentException(ERROR_STRING+
                    "\nExpect : 1~45 범위 숫자" + "\nInput : " + number);
        }
    }

    public void validateTypeNumeric(String WinningNumber){
        for(int i=0;i<WinningNumber.length();i++){
            char c = WinningNumber.charAt(i);
            if(c==',')
                continue;
            if(c<'0'||c>'9')
            {
                throw new IllegalArgumentException("[ERROR] "+
                        " Expect : 숫자 문자" + " Input : " + c);
            }
        }
    }

    public static void validateNumber(String amount) throws IllegalArgumentException{
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.print(ERROR_STRING+" 숫자 문자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }


    public void validateValuePrice(Integer priceInteger){
        if(priceInteger%LOTTO_PRICE!=0)
            throw new IllegalArgumentException(ERROR_STRING +
                    "\nExpect : 1000으로 떨어지는 정수" + "\nInput : " + priceInteger);
    }
}
