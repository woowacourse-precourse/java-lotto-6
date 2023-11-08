package service;

import domain.Lotto;
import domain.Place;
import repository.LottoRepository;

import java.util.Map;

public class LottoService {
    private LottoRepository lottoRepository;

    public LottoService(int size){
        lottoRepository = new LottoRepository(size);
    }
    public void addLotto(Lotto lotto){
        lottoRepository.add(lotto);
    }

    public Map<Place,Integer> numberOfWins(Lotto winningLotto,int bonusNumber){
        lottoRepository.updateAllLottoPlace(winningLotto,bonusNumber);
        return lottoRepository.findAllPlace();
    }
}
