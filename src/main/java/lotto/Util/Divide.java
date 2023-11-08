    package lotto.Util;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    public class Divide {

        public static List<Integer> Delimiter(String Lotto) {
            List<String> lottoNumbersStr = Arrays.asList(Lotto.split(","));
            List<Integer> lottoNumbersInt = ParsingInteger(lottoNumbersStr);
            return lottoNumbersInt;
        }

        private static List<Integer> ParsingInteger(List<String> lottoNumbersStr){
            List<Integer> lottoNumbersInt = new ArrayList<>();

            for (String numberStr : lottoNumbersStr) {
                int numberInt = Integer.parseInt(numberStr);
                lottoNumbersInt.add(numberInt);
            }
            return lottoNumbersInt;
        }

    }
