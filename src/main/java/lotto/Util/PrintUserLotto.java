package lotto.Util;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import static lotto.Constant.Const.LOTTO_WINNING_RESULT_STATISTICS;

// 구현 구상 1
// [1, 2, 3, 4, 5, 6]
// [ + 숫자 + , + (공백숫자) + ... + ]
// 공백숫자,
// 마지막 숫자일 때 , 출력x ]를 출력
//for(0:5)
// if << count == 0 print("[" + ascendingLottoNumber + "," + " ")
// if >> count == 5 print(ascendingLottoNumber + "]");

//구현 구상 2
// List를 String으로 변환 후 "[" "," " ", "]" 추가


public class PrintUserLotto {
    public static void printUserLotto(List<Integer> lottoNumber) {
        List<Integer> ascendingLottoNumber = new ArrayList<>(lottoNumber);
        ascendingLottoNumber.sort(Comparator.naturalOrder());

        StringBuilder lottoNum = new StringBuilder("");

        lottoNum.append("[");
        for (Integer number : ascendingLottoNumber) {
            lottoNum.append(number).append(", ");
        }
        lottoNum.delete(lottoNum.length()-2, lottoNum.length()).append("]");

        System.out.println(lottoNum);
    }

}
