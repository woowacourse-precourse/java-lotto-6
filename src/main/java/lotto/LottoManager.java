package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static constants.Constant.*;
import static service.InputService.*;
import static service.OutputService.*;

public class LottoManager {

    public void run(){

        //로또 구매 입력 및 검증
        String priceString = inputPurchasePrice();
        validateTypeNumeric(priceString);
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

        for(int i=0;i<lottoList.size();i++){
            Lotto lotto = lottoList.get(i);
            String maximumHitCount = findMaxHit(lotto, winningNumber, bonusNumber);
            result.put(maximumHitCount, result.get(maximumHitCount)+1);
        }
        return result;

    }

    public String findMaxHit(Lotto lotto, Lotto winningNumber, Integer bonusNumber){

        boolean bonusNumberFlag = false;
        Integer hitCount = 0;

        for(int i=0; i<Lotto_LENGTH;i++){
            int lottoNum = lotto.getNumber(i);
            int winningNum = winningNumber.getNumber(i);
            if(lottoNum==bonusNumber)
                bonusNumberFlag=true;
            if(lottoNum==winningNum)
                hitCount++;
            else{
                break;
            }
        }

        if(bonusNumberFlag&&hitCount==5)
            return "5+";
        else{
            return String.valueOf(hitCount);
        }

    }

    public List<Integer>convertToList(String input){
        return new ArrayList(Arrays.asList(input.split(SEP_COMMA)));
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                Lotto_BEGIN_RANGE, Lotto_END_RANGE, Lotto_LENGTH);
    }

    public Integer calculateLottoCount(Integer priceInt){
        return priceInt%PRICE_MOD;
    }

    public void validateRangeNumber(Integer number){
        if(number<Lotto_BEGIN_RANGE || number>Lotto_END_RANGE){
            throw new IllegalArgumentException(ERROR_STRING+
                    "\nExpect : 1~45 범위 숫자" + "\nInput : " + number);
        }
    }

    public void validateTypeNumeric(String priceString){
        for(int i=0;i<priceString.length();i++){
            char c = priceString.charAt(i);
            if(c<'0'||c>'9')
            {
                throw new IllegalArgumentException(ERROR_STRING +
                        "\nExpect : 숫자 문자열" + "\nInput : " + priceString);
            }
        }
    }

    public void validateValuePrice(Integer priceInteger){
        if(priceInteger%PRICE_MOD!=0)
            throw new IllegalArgumentException(ERROR_STRING +
                    "\nExpect : 1000으로 떨어지는 정수" + "\nInput : " + priceInteger);
    }
}
