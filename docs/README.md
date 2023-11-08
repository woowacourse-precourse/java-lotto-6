# 로또 게임

## 클래스 별 기능 목록

#### lotto

- Lotto
  - Constructor : 로또의 등수 초기값을 'NO_WIN'으로 설정합니다.
  - validate() : 로또 발급 시에 중복된 수가 있을 경우 IllegalArgumentException()을 호출합니다.
  - getNumbers() : 로또 숫자를 반환합니다.
  - getRank() : 로또의 등수를 반환합니다.
  - setRank() : 로또의 등수를 입력합니다.

- LottoRank (enum)
  - 1등부터 당첨 내역이 없음까지 상수를 나열합니다.
  - 각 등수에 따른 당첨 금액(prize)를 할당합니다.
  - Constructor : 각 등수에 당첨 금액을 설정합니다.
  - getPrize() : 당첨 금액을 반환합니다.

- Application
1. 구입 금액 입력
    - 구입 금액(purchaseAmount)를 입력받고 로또 개수(numberOfLottos)를 계산합니다.
    - 구입 금액이 1) 1000으로 나눠떨어지지 않는 경우, 2) 숫자 형태가 아닌 경우 ERROR 메시지를 출력하고 재입력 받습니다.
2. 로또 발행 및 출력
   - 로또 번호를 생성한 뒤, 리스트(numbers)에 할당하고 정렬을 위해 numbersCopy(ArrayList)로 다시 생성합니다.
   - Collections.sort()를 이용해 오름차순으로 정렬한 뒤, Lotto 리스트에 할당합니다.
   - 구매한 로또 개수와 발행한 로또들을 출력합니다.
3. 당첨 번호와 보너스 번호 입력
   - 당첨 번호 입력을 받고, stream을 이용해 split과 자료형 변환을 하고 리스트(winningNumbers)에 형태로 만듭니다.
   - 당첨 번호 입력에 대해 1) 6개의 숫자 입력, 2) 범위 내에 숫자 입력, 3) 중복 입력, 4) 숫자 이외에 입력 이렇게 4가지 경우 예외 처리를 합니다.
   - 예외 처리된 경우, ERROR 메시지를 출력하고 재입력 받습니다.
   - 보너스 번호를 입력 받고 당첨 번호 리스트에 추가합니다.
   - 예외 처리는 1) 범위 내의 숫자인지, 2) 당첨 번호와 중복은 없는지, 3) 숫자 형태인지 3가지 경우에 대해 진행합니다.
   - 예외 처리된 경우, ERROR 메시지를 출력하고 재입력 받습니다.
4. 당첨 여부 확인 및 등수 부여
   - 로또 리스트(lottos)에서 각 로또들에 대하여 domain.LottoWinChecker를 이용해 당첨 순위를 확인하고 등수를 부여합니다.
5. 당첨 통계 계산 및 출력
   - domain.LottoProfitCalculator를 이용해 당첨 통계를 계산하고 내역과 수익률을 출력합니다.

#### domain

- LottoWinChecker
  - 당첨 번호와 발급 받은 숫자를 비교하고 당첨 내역에 따른 순위를 배정해줍니다.
  - getCorrectNumbersCount() : 당첨 번호와 발급 받은 숫자를 비교하고 맞은 수의 개수를 반환합니다.
  - hasBonusNumber() : 2, 3등 여부를 가를 때에 사용되는 보너스 숫자 여부를 판단합니다.

- LottoProfitCalculator
  - 발급 받은 로또들의 등수에 따라 당첨 내역을 출력하고, 구입 금액에 대한 당첨 금액의 수익률을 계산합니다.
  - setRankCount() : 당첨 내역 출력을 위한 각 등수의 개수를 배정합니다.
  - rankPrinter() : rankCount 배열에 따라 당첨 내역을 반환합니다.
  - profitCalculator() : 각 등수(LottoRank)에 할당된 당첨금(prize)를 합하고 수익률을 계산합니다. 변수의 범위를 넘어가는 경우를 대비해 BigDecimal 클래스를 사용했습니다.
  - getProfitRate() : 수익률을 반환합니다.
  - setProfitRate() : 수익률을 입력합니다.
  - setPrizeAmounts() : 수익금을 입력합니다.