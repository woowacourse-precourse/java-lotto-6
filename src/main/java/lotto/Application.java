package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액 입력
        String input = Console.readLine();
        //로또 구입을 해주는 생성자
        LottoManage lottomanager=new LottoManage(input);
        //당첨번호 입력
        input=Console.readLine();
        List<Integer> lotto_numbers=new ArrayList<>();
        for(String st:input.split(",")){
            lotto_numbers.add(Integer.parseInt(st));
        }
        int bonus=Integer.parseInt(Console.readLine());
        lottomanager.setCorrect_lotto(lotto_numbers,bonus);
        //로또 수량 출력
    }
}
