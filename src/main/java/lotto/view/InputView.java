package lotto.view;

import lotto.util.InputUtil;

import java.util.List;

public enum InputView implements CustomView<Object>{
    INPUT_MONEY{
        @Override
        public Integer activateView() {
            System.out.println("구입금액을 입력해 주세요.");
            return InputUtil.enterMoneyWhileVerifying();
        }
    },
    INPUT_WINNING_NUMBER{
        @Override
        public List<Integer> activateView() {
            System.out.println("당첨 번호를 입력해 주세요.");
            return InputUtil.enterNumbersWhileVerifying();
        }
    },
    INPUT_BONUS_NUMBER {
        @Override
        public List<Integer> activateView() {
            System.out.println("보너스 번호를 입력해 주세요.");
            return InputUtil.enterNumbersWhileVerifying();
        }
    }
}
