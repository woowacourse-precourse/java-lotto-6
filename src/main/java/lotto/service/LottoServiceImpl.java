package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryLottoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;
    private WinLottoService winLottoService;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void buyLotto(int price) {
        for (int i = 0; i < price; i++) {
            List<Integer> lottoNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNum.sort(Comparator.naturalOrder());
            lottoRepository.save(lottoNum);
        }
    }

    @Override
    public List<String> boughtLottoList() {
        List<Lotto> lottoList = lottoRepository.findAll();
        List<String> boughtList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            boughtList.add(lotto.toString());
        }

        return boughtList;
    }

    @Override
    public void setAnswer(Lotto winLotto, int bonusNum) {
        this.winLottoService = new WinLottoService(winLotto, bonusNum);
    }

    @Override
    public void setScore() {
        List<Lotto> lottoList = lottoRepository.findAll();

        for (Lotto lotto : lottoList) {
            int winLottoCheck = winLottoService.matchWinLottoCheck(lotto);
            boolean bonusNumCheck = winLottoService.matchBonusNumCheck(lotto);

            lottoRepository.update(lotto, winLottoService.convertMatch(winLottoCheck, bonusNumCheck));
        }
    }

    @Override
    public int countMatch(Match match) {
        setScore();
        return lottoRepository.findMatchCount(match);
    }

    @Override
    public double calculateYield(int price) {
        double total = 0;
        for (Match match : Match.values()) {
            int count = lottoRepository.findMatchCount(match);
            total += count * match.getPrice();
        }

        return (total / (double) price) * 100;
    }

    @Override
    public void clearAll() {
        lottoRepository.clear();
    }
}
