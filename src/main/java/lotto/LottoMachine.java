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
    public int bonus;
    Lotto[] lotto;

    public void getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try{
            if(Integer.parseInt(input) % 1000 !=0){
                throw new IllegalArgumentException();
            }
            this.count = Integer.parseInt(input)/1000;
        } catch (NumberFormatException e){
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

    public void getWin(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try{
            validateWin(input);
        }catch (IllegalArgumentException e){
            getWin();
        }catch (ArrayIndexOutOfBoundsException e){
            getWin();
        }catch(IllegalStateException e){
            getWin();
        }
        for(String i : input.split(",")){
            win.add(Integer.parseInt(i));
        }
    }

    public void validateWin(String input){
        validateLength(input);
        validateRange(input);
        validateDuplication(input);
    }

    public void addBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try{
            validateBonus(input);
            bonus = Integer.parseInt(input);
        }catch (IllegalArgumentException e) {
            System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            addBonus();
        }catch (IllegalStateException e){
            addBonus();
        }
    }
    public void validateBonus(String input){
        if(win.contains(Integer.parseInt(input))){
            System.out.println("[Error] 중복 되지 않게 입력해주세요.");
            throw new IllegalStateException();
        }
    }

    public void validateLength(String input){
        if(input.split(",").length !=6) {
            System.out.println("[Error] 6개의 로또 번호를 입력해 주세요.");
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public void validateRange(String input){
        for(String i : input.split(",")){
            if(1 > Integer.parseInt(i) || Integer.parseInt(i) > 45){
                System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateDuplication(String input){
        Set<String> set = new HashSet<>();
        for(String i: input.split(",")){
            set.add(i);
        }
        if(set.size() !=6){
            System.out.println("[Error] 중복된 번호가 없게 입력해 주세요.");
            throw new IllegalStateException();
        }
    }

    public void result(){
        int[] winner = new int[win.size()+1];
        int bonusWinner = 0;
        for(Lotto k : lotto){
            winner[k.check(win, bonus)]++;
        }
        drawResult(winner, bonusWinner);
    }

    public void drawResult(int[] winner, int bonusWinner){
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + winner[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + winner[2] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winner[1] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winner[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winner[0] + "개");
        System.out.println("총 수익률은 " + count*1000 + "입니다.");
    }
}
