package lotto.domain;

import static lotto.domain.constants.LottoConstatants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstatants.LOTTO_MIN_NUMBER;
import static lotto.domain.constants.LottoConstatants.LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        winningNumbers = removeWhiteSpace(winningNumbers);
        validateNormalInput(winningNumbers);
        List<Integer>winningNumber = parsingWinningNumbers(winningNumbers);
        validateSize(winningNumber);
        validateDuplicateNumber(winningNumber);
        validateRange(winningNumber);
        this.winningNumbers = winningNumber;
    }

    private String removeWhiteSpace(String winningNumbers){
        winningNumbers = winningNumbers.trim();
        winningNumbers = winningNumbers.replace(" ", "");
        return winningNumbers;
    }

    private void validateNormalInput(String winningNumbers){
        if(!winningNumbers.matches("^-?\\d+(,-?\\d+)*$"))
            throw new IllegalArgumentException("[ERROR] 올바른 입력 형식이 아닙니다.");
    }

    private List<Integer> parsingWinningNumbers(String winningNumbers){
        String[] winningNumber = winningNumbers.split(",");
        List<Integer>temp = new ArrayList<>();
        for (String str : winningNumber) {
            // 문자열을 정수로 변환하여 리스트에 추가합니다.
            temp.add(Integer.parseInt(str));
        }
        return temp;
    }

    private void validateSize(List<Integer>winningNumber){
        if(winningNumber.size() != LOTTO_NUMBERS_SIZE.getValue())
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
    }
    private void validateDuplicateNumber(List<Integer>winningNumber){
        Set<Integer> set = new HashSet<>(winningNumber);
        if(set.size() != 6)
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");

    }

    private void validateRange(List<Integer>winningNumber){
        for(Integer i : winningNumber){
            if(i < LOTTO_MIN_NUMBER.getValue() || i > LOTTO_MAX_NUMBER.getValue())
                throw new IllegalArgumentException("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
