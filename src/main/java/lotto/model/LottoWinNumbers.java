package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoWinNumbers {
    private final ArrayList<String> LOTTO_WIN_NUMBERS;
    private static final String SPECIAL_REGEX = "[!@#$%^&*()_+=\\[\\]{};':\"\\\\|.<>/?-]";
    private static final String NUMERIC_REGEX = "[0-9]";
    public LottoWinNumbers(String winNumbers){
        String[] set = winNumbers.split(",");
        isWrongDelimiter(set);
        isNotDigits(set);
        isWrongNumberRange(set);
        isSameNumber(set);
        //음수 예외처리 추가 필요 -> numberFormatException
        //실수 예외처리 추가 필요 -> numberFormatException
        this.LOTTO_WIN_NUMBERS = determineWinNumbers(set);
    }
    public ArrayList<String> getLottoWinNumbers(){
        return this.LOTTO_WIN_NUMBERS;
    }
    private ArrayList<String> determineWinNumbers(String[] set){
        ArrayList<String> str = new ArrayList<>();
        Collections.addAll(str, set);
        return str;
    }
    private void isWrongDelimiter(String[] set) throws IllegalArgumentException{
        for(String number : set){
            if(number.matches(".*" + SPECIAL_REGEX + ".*")){
                throw new IllegalArgumentException("[ERROR] 잘못된 구분자가 포함되어 있습니다");
            }
        }
    }
    private void isNotDigits(String[] set) throws IllegalArgumentException{
        for(String number : set){
            if(!number.matches(".*" + NUMERIC_REGEX + ".*")){
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 포함되어 있습니다");
            }
        }
    }
    private void isWrongNumberRange(String[] set) throws IllegalArgumentException{
        for(String number : set){
            if(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45){
                throw new IllegalArgumentException("[ERROR] 숫자의 입력은 1이상 45이하의 정수입니다.");
            }
        }
    }
    private void isSameNumber(String[] set) throws IllegalArgumentException{
        HashSet<String> hashSet = new HashSet<>(List.of(set));
        if(hashSet.size() != set.length){
            throw new IllegalArgumentException("[ERROR] 중복된 입력이 있습니다.");
        }
    }





}
