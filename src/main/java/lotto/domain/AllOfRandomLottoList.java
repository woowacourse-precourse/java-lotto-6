package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AllOfRandomLottoList {
    private final List<RandomLottoList> allOfRandomLottoList;
    private int lottoCount = 0;

    public AllOfRandomLottoList() {
        this.allOfRandomLottoList = new ArrayList<>();
    }

    public void addRandomLottoList(RandomLottoList randomLottoList) {
        allOfRandomLottoList.add(randomLottoList);
    }

    public void increaseLottoCount() {
        this.lottoCount++;
    }

    public List<RandomLottoList> getAllOfRandomLottoList() {
        return allOfRandomLottoList;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
