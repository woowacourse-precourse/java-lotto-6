package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액 입력
        String input;
        boolean done=false;
        LottoManage lottomanager = null;
        //로또 구입을 해주는 생성자
        while (!done){
            try {
                input = Console.readLine();
                lottomanager=new LottoManage(input);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //당첨번호 입력
        input=Console.readLine();
        List<Integer> lotto_numbers=new ArrayList<>();
        for(String st:input.split(",")){
            try {
                lotto_numbers.add(Integer.parseInt(st));
            }catch (Exception e){
                throw new IllegalArgumentException();
            }
        }
        try {
            int bonus=Integer.parseInt(Console.readLine());
            lottomanager.setCorrect_lotto(lotto_numbers);
            lottomanager.setBonus(bonus);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        //로또 수량 출력
        lottomanager.print_lottos();
        lottomanager.checkLottoNumbers();
    }
}
