package repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    public List<Lotto> lottoList;
    public LottoRepository(int size){
        lottoList = new ArrayList<>(size);
    }

    public void add(List<Integer> lotto){
        lottoList.add(new Lotto(lotto));
    }

    public List<Lotto> findAll(){
        return lottoList;
    }
    public int size(){
        return lottoList.size();
    }
    public void clear(){
        lottoList.clear();
    }

}
