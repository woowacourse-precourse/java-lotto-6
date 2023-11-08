package lotto.io;


import lotto.domain.lotto.LottoCount;

public interface OutputView {

    void printLottoMessage(LottoMessage lottoMessage);

    void printErrorMessage(String errorMessage);

    void printLottoCountMessage(LottoCount count);
}
