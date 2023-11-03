package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoModel {

    private final InputUI inputUI;
    private List<Lotto> publishedLottos;

    public LottoModel() {
        this.inputUI = new InputUI();
        this.publishedLottos = new ArrayList<>();
    }




}
