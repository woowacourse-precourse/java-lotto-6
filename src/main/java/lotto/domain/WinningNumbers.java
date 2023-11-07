package lotto.domain;

import lotto.util.Constant;
import lotto.util.ErrorConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningNumbers(String winningNumbers){
        List<Integer> validatedNumbers = validate(winningNumbers);
        this.winningNumbers = new ArrayList<>(validatedNumbers);
    }

    public List<Integer> validate(String winningNumbers){
        hasBlank(winningNumbers);
        List<Integer> tmp = new ArrayList<>(6);

        StringTokenizer st = new StringTokenizer(winningNumbers, Constant.WINNING_NUMBER_SEPARATOR);
        while(st.hasMoreTokens()){
            String n = st.nextToken();
            isNumber(n);
            tmp.add(Integer.parseInt(n));
        }
        hasSixNumbers(tmp);
        tmp.forEach(this::hasValidRange);
        isDuplicated(tmp);

        return tmp;
    }

    public void hasBlank(String winningNumbers){
        if(winningNumbers.contains(" ")){
            throw new IllegalArgumentException(ErrorConstant.HAS_BLANK);
        }
    }
    private void isNumber(String n) {
        if(!Pattern.matches(Constant.REGEXP_PATTERN_NUMBER, n)){
            throw new IllegalArgumentException(ErrorConstant.NOT_A_NUMBER);
        }
    }
    public void hasSixNumbers(List<Integer> tmp){
        if(tmp.size()!=6){
            throw new IllegalArgumentException(ErrorConstant.WINNING_NUMBER_SIZE);
        }
    }
    public void isDuplicated(List<Integer> tmp){
        List<Integer> distinctNumbers = tmp.stream()
                .distinct()
                .collect(Collectors.toList());

        if(distinctNumbers.size()!=tmp.size()){
            throw new IllegalArgumentException(ErrorConstant.DUPLICATE_NUMBER);
        }
    }
    public void hasValidRange(Integer n){
        if(n < 1 || n > 45){
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_RANGE);
        }
    }

    public void setBonusNumber(String bonusNumberTxt) {
        isNumber(bonusNumberTxt);
        int tmp = Integer.parseInt(bonusNumberTxt);
        hasValidRange(tmp);
        isDuplicatedWithWinningNumber(tmp);
        this.bonusNumber = tmp;
    }

    public void isDuplicatedWithWinningNumber(Integer tmp){
        if(winningNumbers.contains(tmp)){
            throw new IllegalArgumentException(ErrorConstant.DUPLICATE_NUMBER);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
