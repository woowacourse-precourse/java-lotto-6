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
        this.winningNumbers = new ArrayList<>();
        validate(winningNumbers);

    }

    public void validate(String winningNumbers){
        hasBlank(winningNumbers);

        StringTokenizer st = new StringTokenizer(winningNumbers, Constant.WINNING_NUMBER_SEPARATOR);
        while(st.hasMoreTokens()){
            String n = st.nextToken();
            isNumber(n);
            this.winningNumbers.add(Integer.parseInt(n));
        }
        hasSixNumbers();
        hasValidRange();
        isDuplicated();
    }
    public void hasBlank(String winningNumbers){
        if(winningNumbers.contains(" ")){
            throw new IllegalArgumentException(ErrorConstant.HAS_BLANK);
        }
    }
    private void isNumber(String n) {
        if(!Pattern.matches(Constant.REGEXP_PATTERN_NUMBER, n)){
            winningNumbers.clear();
            throw new IllegalArgumentException(ErrorConstant.NOT_A_NUMBER);
        }

    }
    public void hasSixNumbers(){
        if(winningNumbers.size()!=6){
            winningNumbers.clear();
            throw new IllegalArgumentException(ErrorConstant.WINNING_NUMBER_SIZE);
        }
    }
    public void hasValidRange(){
        long invalidNumbers = winningNumbers.stream()
                .filter(n -> n < 1 || n > 45)
                .count();
        System.out.println(invalidNumbers);
        if(invalidNumbers!=0){
            winningNumbers.clear();
            throw new IllegalArgumentException(ErrorConstant.LOTTO_NUMBER_RANGE);
        }

    }
    public void isDuplicated(){
        List<Integer> distinctNumbers = winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if(distinctNumbers.size()!=winningNumbers.size()){
            winningNumbers.clear();
            throw new IllegalArgumentException(ErrorConstant.DUPLICATE_NUMBER);
        }

    }
}
