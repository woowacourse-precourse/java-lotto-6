package lotto;

import java.util.ArrayList;

public class SeparationNumber {
    public static ArrayList<Integer> separatePrizeNumber(String prizeNumber){ // 당첨 번호에 대한 입력값을 분리하여 리턴한다
        ArrayList<Integer> prizeNumberArray = new ArrayList<>(); // 분리된 값을 저장하기 위해 배열 선언
        String[] splitPrizeNumber = prizeNumber.split(","); // 쉼표를 기준으로 분리한다
        for(String individualNumber : splitPrizeNumber){
            prizeNumberArray.add(Integer.parseInt(individualNumber)); // 분리한 값을 차례대로 배열에 삽입
        }
        return prizeNumberArray;
    }
}
