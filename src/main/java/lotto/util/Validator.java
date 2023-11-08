package lotto.util;

import lotto.enums.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateInteger(String number){
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e){
           throw new lotto.LottoException(LottoException.INVALID_BUYING_PRICE);
        }
    }
    static final int MIN_NATURAL = 1;
    public static void validateNatural(int number){
        if(number < MIN_NATURAL){
            throw new lotto.LottoException(LottoException.INVALID_BUYING_PRICE);
        }
    }
    public static void validateMultiplesOfK(int number, int k){
        if(number % k > 0){
            throw new lotto.LottoException(LottoException.INVALID_BUYING_PRICE);
        }
    }
    public static void validateIfContains(List<Integer> numbers, int num){
        if (numbers.contains(num)) {
            throw new RuntimeException();
        }
    }
    public static void validateSize(List<Integer> numbers, int size){
        if(numbers.size() != size){
            throw new IllegalArgumentException();
        }
    }
    public static void validateIfDuplicateExist(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for(int number: numbers){
            if(set.contains(number)){
                throw new IllegalArgumentException();
            }
            set.add(number);
        }
    }
}
