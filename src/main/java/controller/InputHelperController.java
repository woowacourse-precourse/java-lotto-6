package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import lotto.Lotto;
import model.LottoGenerator;
import view.BonusNumberRequester;
import view.HowManyRequester;
import view.Mainview;
import view.NumberRequster;

class InputHelperController {

    public <T> Integer checkAndRetryMoneyInput(Callable<T> inputMethod, HowManyRequester requester) {
        requester.requestHowMany();
        while (true) {
            try {
                return (Integer) inputMethod.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private <T> Integer[] checkAndRetryNumbersInput(Callable<T> inputMethod, NumberRequster requester) {
        requester.requestNumbers();
        while (true) {
            try {
                return (Integer[]) inputMethod.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public <T> Lotto proceedtoMakingLotto(Callable<T> inputMethod, NumberRequster requster) {
        Integer[] userNumbers = checkAndRetryNumbersInput(inputMethod, requster);
        while (true) {
            try {
                return LottoGenerator.generateLotto(userNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userNumbers = checkAndRetryNumbersInput(inputMethod, requster);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public <T> int checkAndRetryBonusNumberInput(InputMan inputMan, Lotto userLotto,
                                                 BonusNumberRequester requster) {
        requster.requestBonusNumber();
        while (true) {
            try {
                return inputMan.receiveBonusNumber(userLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
