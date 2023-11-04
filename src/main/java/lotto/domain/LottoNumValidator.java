package lotto.domain;

import lotto.util.Constants;
import lotto.util.Util;

import java.util.List;

public class LottoNumValidator {
    private final String LOTTOSTRING;
    public static List<Integer> LOTTONUMS = null;
    public LottoNumValidator(String inputLottoNum) {
        LOTTOSTRING = inputLottoNum;
        LOTTONUMS = Util.toList(inputLottoNum);
        numValidators();
    }
    public void numValidators() {
        isRightNumsString();
        isRightRange();
        isRightSize();
        isNotDuplicate();
    }
    public void isRightNumsString(){
        if (!Constants.numsStringPattern.matcher(LOTTOSTRING).matches()) {
            throw new IllegalArgumentException("로또 번호 입력은 쉼표로 구분되어 있어야 하며, 공백을 포함하지 않아야 하며, 숫자를 입력해야 한다");
        }
    }
    public void isRightRange(){
        if(LOTTONUMS.stream().anyMatch(num->num<1||num>46)){
            throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45까지이다.");
        }
    }
    public void isNotDuplicate(){
        if(LOTTONUMS.size()!=LOTTONUMS.stream().distinct().count()){
            throw new IllegalArgumentException("중복된 로또 당첨 번호는 허용하지 않습니다.");
        }
    }
    public void isRightSize(){
        if(LOTTONUMS.size()!=6){
            throw new IllegalArgumentException("로또 당첨 번호는 6개를 입력해야 합니다.");
        }
    }
}
