package lotto.Logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Logic.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final static int dividePrice=1000;
    int price;
    int count;
    List<Lotto> memberLotto=new ArrayList<>();

    List<Integer> result=new ArrayList<>();
    List<Prize> prize=new ArrayList<>();

    public Member() {
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
    }

    public List<Integer> prizeResult(){

        for (int i=0;i<this.prize.size();i++){

            if(this.prize.get(i).getCount()==5)
                continue;

            int current=this.result.get(this.prize.get(i).getCount());
            this.result.set(this.prize.get(i).getCount(),current+1);
        }

        return this.result;
    }
    public void setPrize(Prize prize){
        this.prize.add(prize);
    }
    public List<Prize> getPrize(){
        return this.prize;
    }

    public double getProfit(){
        double totalPrice=0;

        for(int i=0;i<this.prize.size();i++){
            totalPrice+=this.prize.get(i).getWinningPrize();
        }

        double profit=Math.round((totalPrice / this.price) * 100.0 * 10.0) / 10.0;

        return profit;
    }

    public List<Lotto> getMemberLotto(){
        return memberLotto;
    }
    public int getCount(){
        return this.count;
    }
    public void setCount(int price){
        this.count=price/dividePrice;

        createMemberLotto(this.count);
    }
    public void setPriceValid(String prices) throws IllegalArgumentException{
        try{
            this.price=Integer.parseInt(prices);

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구매금액는 숫자로 표현해야 한다");
        }

        priceValid(this.price);
    }
    public void priceValid(int price) throws IllegalArgumentException{
        if (price<=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 0 이하로 표현하면 안된다");

        if (price % dividePrice!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 1000원 단위로 구매가능하다");
        else if (price % dividePrice==0)
            setCount(price);

    }
    public List<Integer> randomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
    public void createMemberLotto(int count){

        for(int i=0;i<count;i++){
            this.memberLotto.add(new Lotto(randomNumber()));
        }

    }
}
