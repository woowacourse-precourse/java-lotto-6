package service;

import model.EarningRate;
import model.LottoPrize;
import model.LottoRepository;
import model.LottoVendor;
import model.LottoWinningNumbers;

public class LottoService {
    private LottoRepository lottos;
    private LottoPrize lottoPrize;
    private LottoVendor lottoVendor;

    public void createLottos(String purchaseAmount) {
        createLottoVendor(purchaseAmount);
        lottos = lottoVendor.publishLotto(purchaseAmount);
    }

    public void createLottoVendor(String purchaseAmount) {
        lottoVendor = new LottoVendor(purchaseAmount);
    }

    private int getLottoAmount() {
        return lottoVendor.getLottoAmount();
    }

    public LottoRepository getLottoRepository() {
        return lottos;
    }

    public void compareToLotto(LottoWinningNumbers lottoWinningNumbers) {
        lottoPrize = lottos.getWinningLotto(lottoWinningNumbers);
    }

    public EarningRate getEarningRate() {
        return new EarningRate(getLottoAmount() * lottos.getSize(), getWinningPrice());
    }

    public int getWinningPrice() {
        return lottoPrize.getReword();
    }
}
