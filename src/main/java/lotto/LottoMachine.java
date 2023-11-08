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
            if(Integer.parseInt(input) % 1000 !=0){
                throw new IllegalArgumentException();
            }
            this.count = Integer.parseInt(input)/1000;
        } catch (NumberFormatException e2){
            System.out.println(("[Error] 숫자를 입력해줘야 합니다."));
            getMoney();
        } catch(IllegalArgumentException e){
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

    
}
