package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Input {

    public int inputPrice() {
        int price = 0;
        boolean validPrice = false;

        do {
            try {
                price = inputprice();
                validPrice = true;
            } catch (IllegalArgumentException wrongPrice) {
                System.out.println("[ERROR] " + wrongPrice.getMessage());
            }
        } while (!validPrice);
        return price;
    }

    private int inputprice() {
        String rawPrice = Console.readLine();
        checkPrice(rawPrice);
        return Converter.parseToInt(rawPrice);
    }

    private void checkPrice(String rawPrice) {
        int convertedPrice = Converter.parseToInt(rawPrice);

        if (!(convertedPrice % 1000 == 0 && convertedPrice > 0)) {
            throw new IllegalArgumentException("1000원 단위의 정수로 입력해주세요");
        }
    }

    public List<Integer> inputWinNumbers() {
        String rawNumbers = Console.readLine();
        return convertedWinNumber(rawNumbers); // 범위확인 넣을것
    }

    private List<Integer> convertedWinNumber(String rawNumbers) {
        List<Integer> splitNumbers = new ArrayList<>();
        String nowNumbers = rawNumbers;
        while (nowNumbers.contains(",")) {
            int index = nowNumbers.indexOf(",");
            String tempNumbers = nowNumbers.substring(0, index);
            splitNumbers = checkAndthenAdd(tempNumbers, splitNumbers);
            nowNumbers = nowNumbers.substring(index + 1);
        }
        int convertedRawNumber = Converter.parseToInt(nowNumbers);
        splitNumbers.add(convertedRawNumber);
        return splitNumbers;
    }

    private List<Integer> checkAndthenAdd(String tempNumber, List<Integer> splitNumbers) {
        int convertedTempNumber = Converter.parseToInt(tempNumber);
        splitNumbers.add(convertedTempNumber);
        return splitNumbers;
    }

    public int inputBonusNumber () {
        return Converter.parseToInt(Console.readLine()); // 범위확인 넣을것
    }
}
