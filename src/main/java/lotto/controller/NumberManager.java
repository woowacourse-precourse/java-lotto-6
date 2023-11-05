package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberManager {

    protected int checkAddCoinCondition(String readLine){
        if (isItNumber(readLine) && isIt1000wonUnit(readLine)){
            return Integer.parseInt(readLine);
        }else{
            return -1;
        }
    }

    protected Boolean checkBonusNumberCondition(String readLine, Lotto lotto){
        if (isItNumber(readLine) && checkNumberRange(readLine) && lotto.checkContainNumber(Integer.parseInt(readLine))){
            return false;
        }
        return true;
    }

    public Lotto createLotto(){
        List<Integer> lotto = new ArrayList<>();
        for(int i=0 ;i< MessageManager.LOTTO_SIZE; i++) {
            lotto.add(setRandomNumber(lotto));
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    protected int setRandomNumber(List<Integer> lotto){
        int number;
        do{
            number = Randoms.pickNumberInRange(1, 45);
        } while(lotto.contains(number));

        return number;
    }

    protected List<Integer> changeToNumber(List<String> readLine){
        return readLine.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    protected Boolean isItContainOnlyNumber(List<String> readLine){
        for (int i = 0; i < readLine.size(); i++){
            if(!isItNumber(readLine.get(i))){
                return false;
            }
        }
        return true;
    }

    protected Boolean isItNumber(String readLine){
        try{
            Integer.parseInt(readLine);
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_IS_NOT_NUMBER);
            return false;
        }
    }

    protected Boolean isIt1000wonUnit(String readLine){
        if (Integer.parseInt(readLine) % 1000 != 0){
            System.out.println(MessageManager.ERROR_IS_NOT_1000_UNIT);
            return false;
        }else{
            return true;
        }
    }

    private Boolean checkNumberRange(String readline){
        try{
            int number = Integer.parseInt(readline);
            if(number < MessageManager.LOTTO_MIN || number > MessageManager.LOTTO_MAX){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(MessageManager.ERROR_OUT_OF_RANGE);
            return false;
        }
        return true;
    }


}
