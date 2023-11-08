package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CorrectLottoList {
    private final List<LottoManage> correctLottoList;

    public CorrectLottoList() {
        this.correctLottoList = new ArrayList<>();
    }

    public void addCorrectLottoList(LottoManage lottoManage) {
        correctLottoList.add(lottoManage);
    }

    public List<LottoManage> getCorrectLottoList() {
        return correctLottoList;
    }

    public int getLottoMangeCount() {
        return correctLottoList.size();
    }
}
