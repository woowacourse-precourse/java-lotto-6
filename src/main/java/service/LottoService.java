package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lottos;
import repository.LottoRepository;

import java.util.List;

public class LottoService {

    LottoRepository lottoRepository = new LottoRepository();

    public List<Integer> getProgramRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Long save(Lottos lotto_number) {
        return lottoRepository.save(lotto_number);
    }

    public Long lottoSave(List<List<Integer>> lottosList) {
        return lottoRepository.lottoSave(lottosList);
    }

    public int compareLottoList(int i, List<Integer> userlottoList, List<List<Integer>> lottosList, int check) {
        for (int j = 0; j < 6; j++) {
            int current = userlottoList.get(j);
            check = compareEachLottoList(i, current, lottosList, check);
        }
        return check; //최종
    }

    private int compareEachLottoList(int i, int current, List<List<Integer>> lottosList, int check) {
        for (int k = 0; k < 6; k++) {
            int temp = plusCheck(current, lottosList.get(i).get(k));
            check = check + temp;
        }
        return check;
    }

    private int plusCheck(int current, Integer lotto) {
        if(compareEach(current, lotto)) return 1;
        return 0;
    }

    private boolean compareEach(int current, Integer lotto) {
        if (current == lotto) {
            return true;
        }
        return false;
    }
}
