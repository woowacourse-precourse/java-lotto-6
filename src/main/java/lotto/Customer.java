package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer {
    private int count;
    private int price;
    private  final String wantprice="값을 입력하세요: ";
    private final String numstrerr="[ERROR] 숫자를 입력해 주세요.";
    private final String pricerror = "[ERROR] 천원 이상이나 천원단위로 구매해 주세요";
    private final String pricesuccess = "개를 구매했습니다.";
    private final String lottoerr ="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final String equalerr="[ERROR] 중복된 숫자입니다.";

    private final String wantnum = "당첨 번호를 입력해 주세요.";
    private final String wantbonus = "보너스 번호를 입력해 주세요.";
    private int bonus;
    private Lotto mylotto;
    private List<Integer> mynums;

    public void forraffle() {
        while(true){
            try{
                inputlotto();
                mylotto = new Lotto(getmynums());
                validatelotto(mylotto.getlotto());
                inputbonus();
                validatebonus(getbonus(), mylotto.getlotto());

                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지를 출력합니다. 다시 while 루프의 처음으로 돌아가서 값을 다시 입력 받습니다.
            }
        }
    }
    public int inputpprice() {
        while (true) {
            try {
                System.out.print(wantprice);
                String num=Console.readLine();
                price = Integer.parseInt(num);
                validateprice(price);
                break; // 유효한 값을 입력 받으면 while 루프를 빠져나옵니다.
            } catch (NumberFormatException e) {System.out.println(numstrerr);}
            catch (IllegalArgumentException e) {System.out.println(e.getMessage()); /* 에러 메시지를 출력합니다.*/}
        }
        return price;
    }
    public int caltrying(int price){
        count=price/1000;
        System.out.println(getcount() + pricesuccess);
        return count;
    }

    private void inputlotto() {
        try {
            System.out.println(wantnum);
            String name = Console.readLine();
            String[] strnums = name.split(",");
            mynums=new ArrayList<>();
            mynums = changint(strnums, mynums);
        } catch (NumberFormatException e) {
            System.out.println(numstrerr);
        }
    }
    private void inputbonus(){
        try {
            System.out.println(wantbonus);
            bonus = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(numstrerr);
        }
    }
    public int getcount() {
        return count;
    }
    public List<Integer> getmynums(){
        return mynums;
    }
    public int getbonus(){
        return bonus;
    }
    public Lotto getLotto(){return mylotto;}
    public int getPrice(){return price;}
    private List<Integer> changint(String[] strnums, List<Integer> nums){
        for (String num : strnums) {
            nums.add(Integer.parseInt(num.trim()));
        }
        return nums;
    }
    private void validateprice(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(pricerror);
        }
    }
    private void validatelotto(List<Integer> nums){
        for(int num : nums){
            if(num<0||num>45){
                throw new IllegalArgumentException(lottoerr);
            }
        }
    }

    private void validatebonus(int bonus, List<Integer> nums){
        if(bonus<0||bonus>45){
            throw new IllegalArgumentException(lottoerr);
        }
        for(int num : nums){
            if(num==bonus){
                throw new IllegalArgumentException(equalerr);
            }
        }
    }
}
