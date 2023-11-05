package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoCheck {
    private List<Integer>[] lottoPickNumbers; // 로또 구매 값
    private List<Integer> lottoNumber; // 로또 뽑기 값
    private Integer[] lottoResult = new Integer[]{0,0,0,0,0,0,0,0};

    public LottoCheck(List<Integer>[] lottoPickNumbers, List<Integer> lottoNumber) {
        this.lottoPickNumbers = lottoPickNumbers;
        this.lottoNumber = lottoNumber;
    }

    // 로또 값 비교
    public void lottoCompare(){
        for(List<Integer> lotto : lottoPickNumbers){
            lottoResult[lottoCount(lotto,lottoNumber)]++;
        }
    }

    // 결과 값 출력
    public void lottoOutput(){
        System.out.println(Arrays.toString(lottoResult));
    }

    // 로또 결과 값 전달.
    private int lottoCount(List<Integer> lottoPickNumbers,List<Integer> lottoNumber){
        int i = 0;
        for(Integer number : lottoNumber){
            if(lottoPickNumbers.contains(number)) i++;
        }
        if(!(lottoBonus(lottoPickNumbers,lottoNumber))) i++;
        return i;
    }

    // 보너스 값 유무 확인.
    private boolean lottoBonus(List<Integer> lottoPickNumbers,List<Integer> lottoNumber){
        return lottoPickNumbers.contains(pop(lottoNumber));
    }

    //리스트 pop 구현
    private int pop(List<Integer> number){
        return number.get(number.size()-1);
    }
}
