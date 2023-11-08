package lotto;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LottoMachine {
    private int count;
    public List<Integer> win = new ArrayList<>();
    Lotto[] lotto;

    public void getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try{
            this.count = Integer.parseInt(input)/1000;
        } catch (IllegalArgumentException e){
            System.out.println(("[Error] 1000원 단위로 나누어 떨어져야 합니다."));
            getMoney();
        }

    }

    public void makeLotto(){
        lotto = new Lotto[this.count];
        for(int i = 0; i < this.count; i++){
            lotto[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void printLotto(){
        System.out.println(this.count + "개를 구매했습니다.");
        for(int i = 0 ; i < this.count; i++){
            lotto[i].printNumber();
        }
    }

    public void getWin(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        for(String i : input.split(",")){
            try{
                if(Integer.parseInt(i) > 45 || Integer.parseInt(i) < 1){
                    throw new IllegalArgumentException();
                }
                win.add(Integer.parseInt(i));
            }catch (IllegalArgumentException e){
                System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                getWin();
            }
        }
    }
}
