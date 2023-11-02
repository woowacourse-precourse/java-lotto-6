package lotto;

import java.util.List;

public class Member {
    UI ui=new UI();
    int price;
    List<Lotto> memberLotto;

    public Member() {
    }

    public void setPrice(String prices){

    }
    public List<Lotto> getMemberLotto(){
        return memberLotto;
    }
    public int getCount(){
        return memberLotto.size();
    }
}
