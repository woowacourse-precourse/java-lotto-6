package lotto.utils;

import java.util.List;

public class Validator {

    public static void checkAmount(Integer purchaseAmount) throws IllegalArgumentException{
        if((purchaseAmount % 1000) != 0 || purchaseAmount <= 0){
            throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력 해주세요");
        }
    }

    public static String checkNullValue(String inputValue) throws IllegalArgumentException{
        if(inputValue == ""){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다 확인해주세요");
        }
        return inputValue;
    }

    public static void checkWinningNumber(List<Integer> winningNumber) throws IllegalArgumentException{
        checkWinningNumberSize(winningNumber);
        checkLottoNumberRange(winningNumber);
        checkLottoNumberDuplicate(winningNumber);
    }

    public static void checkBonusNumber(List<Integer> winningNumber, Integer bonusNumber) throws IllegalArgumentException{
        checkLottoNumberRange(bonusNumber);
        checkLottoNumberDuplicate(winningNumber, bonusNumber);
    }


    private static void checkWinningNumberSize(List<Integer> winningNumber) throws IllegalArgumentException{
        if(winningNumber.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
        }
    }

    private static void checkLottoNumberRange(List<Integer> lottoNumber) throws IllegalArgumentException{
        for(Integer number : lottoNumber){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 각 로또 번호는 1과 45 사이의 값이어야 합니다.");
            }
        }
    }

    private static void checkLottoNumberRange(Integer lottoNumber) throws IllegalArgumentException{
        if(lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 1과 45 사이의 값이어야 합니다.");
        }
    }



    private static void checkLottoNumberDuplicate(List<Integer> lottoNumber) throws IllegalArgumentException{
        Long lottoNumberCount = lottoNumber.stream().distinct().count();
        if(lottoNumberCount != lottoNumber.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    private static void checkLottoNumberDuplicate(List<Integer> winningNumber, Integer bonusNumber) throws  IllegalArgumentException{
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 입력된 보너스 번호가 당첨 번호에 포함됩니다.");
        }
    }

}
