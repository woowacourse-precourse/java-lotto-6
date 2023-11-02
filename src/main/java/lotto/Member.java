package lotto;

import java.util.List;

public class Member {
    private final static int dividePrice=1000;
    int price;
    int count;
    List<Lotto> memberLotto;

    public Member() {
    }

    public void setPrice(String prices){ //숫자인지 판단
        try{
            this.price=Integer.parseInt(prices);

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구매금액는 숫자로 표현해야 한다");
        }

        priceValid(this.price);
    }
    public void priceValid(int price){ //0이상, 1000원 단위인지 판단
        if (price<=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 0 이하로 표현하면 안된다");

        if (price % dividePrice!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액는 1000원 단위로 구매가능하다");
        else if (price % dividePrice==0)
            setCount(price);

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
    public void createMemberLotto(int count){

    }
}
