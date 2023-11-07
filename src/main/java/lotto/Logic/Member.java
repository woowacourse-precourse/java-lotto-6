package lotto.Logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Logic.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final static int dividePrice=1000;
    private int price;
    private int count;
    private List<Lotto> memberLotto=new ArrayList<>();
    private List<Prize> prize=new ArrayList<>();
    private List<Integer> result=new ArrayList<>();


    public Member() {
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
        this.result.add(0);
    }


    public List<Prize> getPrize(){
        return this.prize;
    }

    public int getPrice(){
        return this.price;
    }

    public List<Lotto> getMemberLotto(){
        return this.memberLotto;
    }

    public int getCount(){
        return this.count;
    }

    public void setPrize(Prize prize){
        this.prize.add(prize);
    }

    public void setCount(int price){
        this.count=price/dividePrice;

        createMemberLotto(this.getCount());
    }

    public void setPriceValid(String prices) throws IllegalArgumentException{
        try{
            this.price=Integer.parseInt(prices);

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구매금액는 숫자로 표현해야 한다");
        }

        priceValid(this.getPrice());
    }

    public void priceValid(int price) throws IllegalArgumentException{
        if (price<=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 0 이하로 표현하면 안된다");

        if (price % dividePrice!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 1000원 단위로 구매가능하다");
        else if (price % dividePrice==0)
            setCount(price);

    }

    public String getProfit(){
        double totalPrice=0;

        for(int i=0;i<this.prize.size();i++){
            totalPrice+=this.prize.get(i).getWinningPrize();
        }

        double percentPrice=(totalPrice / this.price) * 100;
        double profit=Math.round(percentPrice * 10.0) / 10.0;

        String formattedProfit = String.format("%.1f", profit);

        return formattedProfit;
    }

    public List<Integer> randomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public void createMemberLotto(int count){

        for(int i=0;i<count;i++)
            this.getMemberLotto().add(new Lotto(randomNumber()));
    }

    public List<Integer> prizeResult(){

        for (int i=0;i<this.prize.size();i++){

            if(this.prize.get(i).ordinal()==5)
                continue;

            int current=this.result.get(this.prize.get(i).ordinal());
            this.result.set(this.prize.get(i).ordinal(),current+1);
        }

        return this.result;
    }

}
