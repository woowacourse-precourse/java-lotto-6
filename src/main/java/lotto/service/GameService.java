package lotto.service;

import lotto.domain.*;
import lotto.exception.CommonException;
import lotto.util.GenerateLottoNumberUtil;
import lotto.util.WiningResultUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;
import java.util.stream.LongStream;

public class GameService {
    private final InputView inputView;
    private final OutputView outputView;
    private final GenerateLottoNumberUtil generateLottoNumberUtil;
    private RateOfReturn rateOfReturn;
    private WiningResultUtil winingResultUtil;
    private PurchaseCost purchaseCost;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;


    public GameService(){
        inputView = new InputView();
        outputView = new OutputView();
        generateLottoNumberUtil = new GenerateLottoNumberUtil();
    }

    /**
     * 구입 금액 입력 받는 과정
     */
    public void purchase(){
        purchaseCost = new PurchaseCost(inputView.inputPurchaseCost());
        outputView.purchaseCount(purchaseCost.getPurchaseCost());
        rateOfReturn = new RateOfReturn(purchaseCost.getPurchaseCost());
    }


    /**
     * 로또 번호 랜덤 생성 과정
     */
    public void generateLottoNumber(){
        LongStream.range(0, purchaseCost.getPurchaseCost())
                .forEach(i -> {
                    generateLottoNumberUtil.generateLottoNumber();
                    outputView.randomLottoNumber(generateLottoNumberUtil.getGenerateLottoNumber());
                });
    }


    /**
     * 당첨 번호 입력 과정
     */
    public void winningNumber(){
        winningNumber = new WinningNumber(inputView.inputWinningNumber());
    }

    /**
     * 보너스 번호 입력 과정
     */
    public void bonusNumber(){
        bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        CommonException.commonException(winningNumber.getWinningNumber(),bonusNumber.getNumber());
    }


    /**
     * 당첨번호 + 보너스 번호와 일치하는 로또 번호 리스트 파악하는 과정
     */
    public void winning() {
        winingResultUtil = new WiningResultUtil();
        winingResultUtil.setWinning(generateLottoNumberUtil.getLottos(),winningNumber.getWinningNumber());
        Map<String, Integer> matchCounts
                = winingResultUtil.calculateMatchCount(bonusNumber.getNumber(),rateOfReturn);
        outputView.winningStatics();
        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            String message = entry.getKey();
            int count = entry.getValue();
            if (!message.isEmpty()) {
                outputView.winningRate(message,count);
            }
        }
    }

    /**
     * 수익률 계산하는 과정
     */
    public void revenue(){
        rateOfReturn.setRateOfReturn();
        outputView.rateOfReturn(rateOfReturn.getRateOfReturn());
    }

}
