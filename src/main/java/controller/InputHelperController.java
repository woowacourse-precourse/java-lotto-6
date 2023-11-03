package controller;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import lotto.Lotto;
import model.LottoGenerator;
import view.Mainview;

class InputHelperController {

    private Mainview mainview;

    public InputHelperController(Mainview mainview) {
        this.mainview = mainview;
    }

    public <T> Integer checkAndRetryMoneyInput(Callable<T> inputMethod) {
        mainview.askForHowMany();
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

    private <T> Integer[] checkAndRetryNumbersInput(Callable<T> inputMethod) {
        mainview.requestNumbers();
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

    public <T> Lotto proceedtoMakingLotto(Callable<T> inputMethod) {
        Integer[] userNumbers = checkAndRetryNumbersInput(inputMethod);
        while (true) {
            try {
                return LottoGenerator.generateLotto(userNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                userNumbers = checkAndRetryNumbersInput(inputMethod);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public <T> int checkAndRetryBonusNumberInput(InputMan inputMan, Lotto userLotto)
    {
        mainview.requestBonusNumber();
        while (true) {
            try {
                return inputMan.receiveBonusNumber(userLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
