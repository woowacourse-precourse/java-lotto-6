package lotto.Model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UserLotto {

    private final List<Integer> numbers;
    int[] cnt = new int[46];
    public UserLotto(List<Integer> numbers){
        Arrays.fill(cnt, 0);
        validate(numbers);
        this.numbers = numbers;
    }

    public void addBonusNumber(int num){
        if(!bonusNumberValidate(num))
            throw new IllegalArgumentException();
        else
            numbers.add(num);
    }

    // 보너스 번호 제외 당첨번호 6개를 받았을 때 유효성 검사
    private void validate(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException();
        }else{
            if(!duplicationCheck(numbers)){
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean duplicationCheck(List<Integer> numbers){
        boolean result = true;
        Iterator<Integer> it = numbers.iterator();

        while(it.hasNext())
            cnt[it.next()]++;

        for(int i = 1; i < 46; i++){
            if(cnt[i] > 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean bonusNumberValidate(int bonusNumber){
        boolean result = true;

        if(cnt[bonusNumber] >= 1)
            result = false;

        return result;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
