package lotto.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvalidlputException {

    private static final String NULL_EXCEPTION_MESSAGE = "[ERROR] 입력값이 null입니다.";
    private static final String LOTTO_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45사이의 숫자여야합니다.";
    private static final String LOTTO_NUMBERS_AMOUNT_MESSAGE = "[ERROR] 6개 숫자를 입력해주세요.";
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "[ERROR] 6개 모두 다른 숫자여야합니다.";
    private static final String LOTTO_MONEY_RANGE_MESSAGE = "[ERROR] 로또 구매금액은 1000원 이상이어야합니다.";
    private static final String LOTTO_MONEY_DIVIDE_MESSAGE = "[ERROR] 로또 구매금액은 1000원 이상이어야합니다.";
    private static final String BONUS_DUPLICATION_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 당첨번호 숫자들과 다른 수여야합니다.";
    //private static final String BONUS_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 당첨번호 숫자들과 다른 수여야합니다.";


        // 중복검사
        public static void duplicateLottoNumber(List<Integer> lottoRandomNumbers){
            Set<Integer> checkLottoNumbers = new HashSet<>(lottoRandomNumbers);
            if(checkLottoNumbers.size() != lottoRandomNumbers.size()){
                throw new IllegalArgumentException();
            }
        }

        // 보너스 번호 중복검사
        public static void bounsDuplication(List<Integer> lottoRandomNumbers, int bonusLottoNumber){
            for(int i=0; i<lottoRandomNumbers.size(); i++){
                if(lottoRandomNumbers.get(i)==bonusLottoNumber){
                    throw new IllegalArgumentException();
                }
            }
        }

        public static void validateInputIsEmpty(String input) {
            if (input.isBlank()) {
                throw new IllegalStateException(NULL_EXCEPTION_MESSAGE);
            }
        }

        public static void validateLottoRange(List<Integer> winningNumbers) {
            for (int num : winningNumbers) {
                if (num < 1 || num > 45) {
                    throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION_MESSAGE);
                }
            }
        }

        public static void validateLottoNumbersAmount(List<Integer> winningNumbers) {
            if(winningNumbers.size() != 6) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_AMOUNT_MESSAGE);
            }
        }

        public static void validateMoneyRange(int money){
            if(!(money>=1000)){
                throw new IllegalStateException(LOTTO_MONEY_RANGE_MESSAGE);
            }
        }

        public static void validateMoneyDivided(int money){
            if(!(money%1000==0)){
                throw new IllegalStateException(LOTTO_MONEY_DIVIDE_MESSAGE);
            }
        }





}
