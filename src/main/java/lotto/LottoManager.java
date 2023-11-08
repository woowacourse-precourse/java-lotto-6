package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

//        String bonusNumberString = inputBonusNumber();
//        validateTypeNumeric(bonusNumberString);
//        Integer bonusNumberInteger = Integer.parseInt(bonusNumberString());
//        validateRangeNumber(bonusNumberInteger);
//
//        HashMap<Integer, Integer> result = calucateResult(lottoList, winningNumbers, bonusNumberInteger);


    }

    private List<Integer>convertToList(String input){
        return new ArrayList(Arrays.asList(input.split(SEP_COMMA)));
    }

    private List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                Lotto_BEGIN_RANGE, Lotto_END_RANGE, Lotto_LENGTH);
    }

    private Integer calculateLottoCount(Integer priceInt){
        return priceInt%PRICE_MOD;
    }

    private void validateTypeNumeric(String priceString){
        for(int i=0;i<priceString.length();i++){
            char c = priceString.charAt(i);
            if(c<'0'||c>'9')
            {
                throw new IllegalArgumentException(ERROR_STRING +
                        "\nExpect : 숫자 문자열" + "\nInput : " + priceString);
            }
        }
    }

    private void validateValuePrice(Integer priceInteger){
        if(priceInteger%PRICE_MOD!=0)
            throw new IllegalArgumentException(ERROR_STRING +
                    "\nExpect : 1000으로 떨어지는 정수" + "\nInput : " + priceInteger);
    }
}
