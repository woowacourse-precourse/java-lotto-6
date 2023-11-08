package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.input.InputService;
import lotto.output.PrintService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Customer customer = getCustomer();
        Integer buyCount = customer.getBuyCount();
        buyLotto(customer, buyCount);
        Lotto lotto = new Lotto(inputWinNumbers());
        int bonusNumber = inputBonusNumber();
        Map<Integer, Integer> result = WinStatistics.result(customer.getLottoNumbers(),
            lotto.getNumbers(),
            bonusNumber);
        customer.winPrice(result);
        announceResult(customer, result);
    }

    private static void announceResult(Customer customer, Map<Integer, Integer> result) {
        PrintService.announceWin();
        PrintService.result(result);
        PrintService.totalRateOfReturn(customer.calcRateOfReturn());
        InputService.close();
    }

    private static Customer getCustomer() {
        try {
            PrintService.requestInputPurchasePrice();
            String purchasePrice = InputService.purchasePrice();
            return Customer.create(purchasePrice);
        }catch (NumberFormatException e) {
            PrintService.error(e.getMessage());
            return getCustomer();
        }catch (IllegalArgumentException e) {
            PrintService.error(e.getMessage());
            return getCustomer();
        }
    }

    private static void buyLotto(Customer customer, Integer buyCount) {
        PrintService.informPurchaseCount(buyCount);
        Map<Integer, List<Integer>> createLottoNumbers = LottoMachine.create(buyCount);
        customer.putLottoNumber(createLottoNumbers);
        PrintService.buyLottoNumbers(customer.getLottoNumbers());
    }

    private static int inputBonusNumber() {
        PrintService.requestInputBonusNumber();
        return Integer.parseInt(InputService.provideBonusNumber());
    }

    private static List<Integer> inputWinNumbers() {
        PrintService.requestInputWinNumber();
        String winNumber = InputService.winNumber();
        List<String> winNumbers = new ArrayList<>(Arrays.asList(winNumber.split(",")));
        return ListDataTypeConverter.stringToInteger(winNumbers);
    }
}
