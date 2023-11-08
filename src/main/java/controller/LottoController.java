/**
 * @Package_name : controller
 * @Class_name : LottoController
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import model.Lotto;
import model.LottoNumberPicker;
import model.LottoNumberComparater;
import model.LottoNumberSetHolder;
import model.LottoResultJudger;
import model.LottoTicketSeller;
import model.LottoWinResultsHolder;
import model.lottoException.LottoNumNotSixException;
import model.lottoException.LottoNumSameException;
import model.lottoException.LottoNumberRangeException;
import view.InputView;
import view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    /**
     * Description : 로또 중심 로직 컨트롤러
     *
     * @Method : controlLotto()
     */
    public void controlLotto() {

        int money = getMoney();
        int lottoTicketNum = playLottoTicketSeller(money);

        LottoNumberSetHolder lottoNumberSetHolder = playLottoNumberPicker(lottoTicketNum);

        LottoNumberComparater lottoNumberComparater = playLottoNumberComparater();

        LottoWinResultsHolder lottoWinResultsHolder = makeLottoWinResultsHolder(lottoNumberSetHolder, lottoNumberComparater);

        Map<String, Integer> winResults =playLottoWinResultsHolder(lottoWinResultsHolder);

        playLottoResultJudger(winResults,money);
    }

    /**
     * Description : 금액 받기
     *
     * @Method : getMoney()
     */
    public int getMoney() {
        int finalMoney;
        while (true) {
            outputView.printLottoBuy();
            String money = inputView.inputLottoBuy();
            try {
                int intNum = errorNonNumberNum(money);
                error1000NoneNum(intNum);
                finalMoney = intNum;
                outputView.printNextLine();
                break;
            } catch (NumberFormatException e) {
                outputView.printLottoNumberRightError();
            } catch (IllegalArgumentException e) {
                outputView.printPrizeSizeError();
            }
        }
        return finalMoney;
    }

    /**
     * Description : LottoTicketSeller에게 돈 전달, 출력
     *
     * @Method : playLottoTicketSeller()
     */
    public int playLottoTicketSeller(int money) {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(money);
        int lottoTicketNum = lottoTicketSeller.receiveLottotickets();
        outputView.printLottoBuyComplete(lottoTicketNum);
        return lottoTicketNum;
    }

    /**
     * Description : 로또 장수만큼 번호들 뽑고 저장, 출력. 로또 저장한 LottoNumberSetHolder 반환
     *
     * @Method : playLottoNumberPicker()
     */
    public LottoNumberSetHolder playLottoNumberPicker(int lottoTicketNum) {
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        LottoNumberSetHolder lottoNumberSetHolder = new LottoNumberSetHolder();
        while (lottoTicketNum-- > 0) {
            List<Integer> LottoNums = lottoNumberPicker.lottoNumberPick();
            Lotto lotto = getLotto(LottoNums);
            lottoNumberSetHolder.lottoNumberSetAdd(lotto);
            outputView.printLottoNums(LottoNums);
        }
        outputView.printNextLine();
        return lottoNumberSetHolder;
    }
    /**
     * Description : 로또 에러 예외처리
     *
     * @Method : getLotto()
     */
    public Lotto getLotto(List<Integer> LottoNums){
        Lotto newLotto;
        while(true){
            try {
                newLotto = new Lotto(LottoNums);
                return newLotto;
            } catch (LottoNumNotSixException e) {
                outputView.printLottoSizeNoneSixError();
            }catch (LottoNumberRangeException e) {
                outputView.printLottoNumRangeError();
            } catch (LottoNumSameException e) {
                outputView.printLottoNumSameError();
            }
        }
    }

    /**
     * Description : 로또/보너스 숫자 받아 정답 로또값 담은 LottoNumberComparater 생성
     *
     * @Method : playLottoNumberComparater()
     */
    public LottoNumberComparater playLottoNumberComparater() {
        ArrayList<Integer> resultLottoNum = getLottoNum();
        outputView.printNextLine();
        int BonusNum = getBonusNum(resultLottoNum);

        return new LottoNumberComparater(resultLottoNum, BonusNum);
    }

    /**
     * Description : 로또 숫자 받기 (예외처리)
     *
     * @Method : getLottoNum()
     */
    public ArrayList<Integer> getLottoNum() {
        outputView.printLottoNumRequest();
        ArrayList<Integer> lottoNum;
        while(true){
            try {
                lottoNum = inputView.inputLottoNum();
                new Lotto(lottoNum);
                return lottoNum;
            } catch (LottoNumNotSixException e) {
                outputView.printLottoSizeNoneSixError();
            }catch (LottoNumberRangeException e) {
                outputView.printLottoNumRangeError();
            }catch (LottoNumSameException e) {
                outputView.printLottoNumSameError();
            }
        }
    }

    /**
     * Description : 보너스 숫자 받기
     *
     * @Method : getBonusNum()
     */
    public int getBonusNum(ArrayList<Integer> resultLottoNum) {
        int finalBonusNum;
        while(true){
            outputView.printBonusNumRequest();
            String resultBonusNum = inputView.inputBonusNum();
            try {
                int intBonusNum = errorNonNumberNum(resultBonusNum);
                errorNumberSame(intBonusNum,resultLottoNum);
                finalBonusNum = intBonusNum;
                return finalBonusNum;
            }catch (NumberFormatException e){
                outputView.printLottoNumberRightError();
            }catch (LottoNumSameException e) {
                outputView.printLottoNumSameError();
            }
        }
    }

    /**
     * Description : 숫자 아님 오류
     *
     * @Method : errorNonNumberNum()
     */
    public int errorNonNumberNum(String resultBonusNum) throws NumberFormatException {
        return Integer.parseInt(resultBonusNum);
    }
    /**
     * Description : 보너스 숫자용 로또 숫자 겹침 오류
     *
     * @Method : errorNumberSame()
     */
    public void errorNumberSame(int bonusNum, ArrayList<Integer> resultLottoNum) throws LottoNumSameException {
        if (resultLottoNum.contains(bonusNum)) {
            throw new LottoNumSameException();
        }
    }

    /**
     * Description : 금액 오류(1000 안나눠짐)
     *
     * @Method : error1000NoneNum()
     */
    public void error1000NoneNum(int prize) throws IllegalArgumentException {
        if (prize % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Description : LottoNumberSetHolder에 든 로또들을 각각 LottoNumberComparater에 넣어 결과를 받고, 상 결과 담은 lottoWinResultsHolder 생성
     *
     * @Method : makeLottoWinResultsHolder()
     */
    public LottoWinResultsHolder makeLottoWinResultsHolder(LottoNumberSetHolder lottoNumberSetHolder, LottoNumberComparater lottoNumberComparater){
        ArrayList<Lotto> LottoNumberSet = lottoNumberSetHolder.getLottoNumberSet();
        LottoWinResultsHolder lottoWinResultsHolder = new LottoWinResultsHolder();
        for (Lotto lotto : LottoNumberSet) {
            String LottoWinResult = lottoNumberComparater.comparaterLottoResult(lotto.getLottoNumbers());
            lottoWinResultsHolder.lottoWinResultsAdd(LottoWinResult);
        }
        outputView.printNextLine();

        return lottoWinResultsHolder;
    }

    /**
     * Description :  lottoWinResultsHolder에게서 상 결과 가져와 출력
     *
     * @Method : playLottoWinResultsHolder()
     */
    public Map<String, Integer> playLottoWinResultsHolder(LottoWinResultsHolder lottoWinResultsHolder){
        Map<String, Integer> winResults = lottoWinResultsHolder.getWinResults();
        outputView.printWinStatistic(winResults);
        return winResults;
    }

    /**
     * Description : 상금 결과와 구입 금액 가져와 수익률 출력
     *
     * @Method : makeLottoWinResultsHolder()
     */
    public void playLottoResultJudger(Map<String, Integer> winResults,int money) {
        LottoResultJudger lottoResultJudger = new LottoResultJudger(winResults, money);
        double profit = lottoResultJudger.getProfit();
        outputView.printTotalProfit(profit);
    }

}

