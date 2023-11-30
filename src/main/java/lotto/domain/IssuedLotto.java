package lotto.domain;

import java.util.List;

public class IssuedLotto {
    private List<Integer> Issued_Lotto_Numbers;

    public IssuedLotto(List<Integer> Issued_Lotto_Numbers){
        this.Issued_Lotto_Numbers = Issued_Lotto_Numbers;
    }

    public List<Integer> findAll(){
        return Issued_Lotto_Numbers;
    }
}
