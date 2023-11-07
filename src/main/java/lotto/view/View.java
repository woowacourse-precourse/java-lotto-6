package lotto.view;
public class View {

    public enum PrintOutput {
        START("구입금액을 입력해 주세요."),
        WINNINGNUMBER("당첨 번호를 입력해 주세요."),
        BONUSNUMBER("보너스 번호를 입력해 주세요."),
        STATISTICS("당첨 통계"),
        ;
        private final String label;

        PrintOutput(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    public static void printStartMessage () {
        System.out.println(PrintOutput.START.label);
    }
}
