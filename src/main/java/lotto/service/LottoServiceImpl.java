package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryLottoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoServiceImpl implements LottoService{

    private LottoRepository lottoRepository = new MemoryLottoRepository();
    private WinLottoService winLottoService;

    @Override
    public void buyLotto(int price) {
        for(int i = 0; i < price; i++) {
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNum.sort(Comparator.naturalOrder());
            lottoRepository.save(lottoNum);
        }
    }

    @Override
    public List<String> boughtLottoList() {
        List<Lotto> lottoList = lottoRepository.findAll();
        List<String> boughtList = new ArrayList<>();

        for(Lotto lotto : lottoList) {
            boughtList.add(lotto.toString());
        }

        return boughtList;
    }

    @Override
    public void setAnswer(List<Integer> answerList, int bonusNum) {
        Lotto winLotto = new Lotto(answerList);
        this.winLottoService = new WinLottoService(winLotto, bonusNum);
    }

    @Override
    public void setScore() {
        List<Lotto> lottoList = lottoRepository.findAll();

        for(Lotto lotto : lottoList) {
            lottoRepository.update(lotto, winLottoService.convertMatch(lotto));
        }
    }

    @Override
    public Long calculateYield(int price) {
        int total = 0;
        for(Match match : Match.values()) {
            int count = lottoRepository.findByMatch(match);
            total = count * match.getPrice();
        }

        return  (total / (long) price);
    }
}
