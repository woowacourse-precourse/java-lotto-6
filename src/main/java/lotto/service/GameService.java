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
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GenerateLottoNumberUtil generateLottoNumberUtil = new GenerateLottoNumberUtil();
    WinningRate winningRate;
    RateOfReturn rateOfReturn;
    WiningResultUtil winingResultUtil;

    PurchaseCost purchaseCost;
    WinningNumber winningNumber;
    BonusNumber bonusNumber;


    public GameService(){
        //이 부분 controller로 빼기
       purchase();
       generateLottoNumber();
       winningNumber();
       bonusNumber();
       winning();
       revenue();
    }

    public void purchase(){
        purchaseCost = new PurchaseCost(inputView.inputPurchaseCost());
        outputView.purchaseCount(purchaseCost.getPurchaseCost());
        rateOfReturn = new RateOfReturn(purchaseCost.getPurchaseCost());
    }

    public void generateLottoNumber(){
        //PurchaseCost만큼 랜덤 로또번호 생성 및 로또 클래스에 저장 및 OutView에 리턴해서 출력
        LongStream.range(0, purchaseCost.getPurchaseCost())
                .forEach(i -> {
                    generateLottoNumberUtil.generateLottoNumber();
                    outputView.randomLottoNumber(generateLottoNumberUtil.getGenerateLottoNumber());
                });
    }

    public void winningNumber(){
        winningNumber = new WinningNumber(inputView.inputSelectNumber());
    }
    public void bonusNumber(){
        bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        CommonException.commonException(winningNumber.getWinningNumber(),bonusNumber.getNumber());
    }

    public void winning() {
        winingResultUtil = new WiningResultUtil();
        winingResultUtil.setWinning(generateLottoNumberUtil.getLottos(),winningNumber.getWinningNumber());
        Map<String, Integer> matchCounts = winingResultUtil.calculateMatchCount(bonusNumber.getNumber(),rateOfReturn);

        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            String message = entry.getKey();
            int count = entry.getValue();
            if (!message.isEmpty()) {
                outputView.winningRate(message,count);
            }
        }
    }

    public void revenue(){
        rateOfReturn.setRateOfReturn();
        outputView.rateOfReturn(rateOfReturn.getRateOfReturn());
    }

}
