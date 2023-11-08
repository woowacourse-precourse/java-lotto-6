    package lotto.LottoFactory;

    import lotto.Util.Sorting;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    public class LottoContainer implements LottoChecker {
        private List<Lotto> lottoContainer = new ArrayList<>();
        private List<Integer> WinningLotto = new ArrayList<>();

        public void MakeContainer(int count){
            for(int i=0; i<count; i++){
                lottoContainer.add(Lotto.createLotto());
            }
        }

        public void MakeWinningLotto(List<Integer> WinningInput){
            WinningLotto.addAll(WinningInput);
        }

        @Override
        public boolean isDuplicateBonus(int bonus) {
            return WinningLotto.contains(bonus);
        }

        @Override
        public int countMatchingNum(Lotto lotto) {
            int count = 0;
            for (int number : lotto.getNumbers()) {
                if (WinningLotto.contains(number)) {
                    count++;
                }
            }
            return count;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            // 로또 번호 출력
            for (Lotto lotto : lottoContainer) {
                List<Integer> sortedNumbers = Sorting.LottoNum(lotto.getNumbers());
                sb.append(sortedNumbers).append("\n");
            }

            return sb.toString();
        }

        public List<Lotto> getLottoContainer() {
            return lottoContainer;
        }

    }
