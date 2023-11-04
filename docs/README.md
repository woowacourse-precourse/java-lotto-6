## 입력 - Input

- 금액 - **amount**
- 당첨 번호 - **winningNumber**
- 보너스 번호 - **bonusNumber**

## 자료형 변환 - **TypeConverter**

- String > int - **stringToInt**
- String > ArrayList(쉼표로 구분) - **stringToArrayList**

## 출력 - Output

- 로또 발행 개수 - **purchasedLottoCount**
- 로또 번호 - **purchasedLottoNumbers**
- 등수별 당첨 내역 - **winningResultsByRank**
- 수익률 - **profitRate**

## 예외 처리 - **ExceptionHandler**

- 0 이하의 값이 아닌지 (구매 금액) - **checkNonNegativeAmount**
- 1,000원으로 나누어 떨어지는 지 (구매 금액) - **checkMultipleOfThousand**-
- null 값 확인 (ArrayList, int) - **checkNotNull**
- 빈값 확인(띄어쓰기) - **checkNotEmpty**
- 숫자인지 (ArrayList, int) - **checkInteger**
- 중복값 확인 - **checkDuplicates**
- 1~45사이의 수인지 - **checkInRange**
- 6개의 숫자인지 (당첨 번호) - **checkSixNumbers**
- 1개의 숫자인지 (보너스 번호) - **checkSingleNumber**

## 로또 - Lotto

- 1~45 사이의 숫자로 이루어진 중복되지 않는 6개의 로또 번호를 생성 - **createLottoNumbers**
- 입력된 금액에 따라 로또를 발행 - **purchaseLotto**

## 당첨 - Match

- 사용자의 로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 반환 (HashSet) - **checkMatchingNumbers**
- 보너스 번호가 일치하는지 확인하고, 일치 여부를 반환 - **checkBonusNumber**
- 당첨금 - **calculatePrizeAmount**

## 수익률 - ProfitRate

- 일치하는 번호의 개수에 따라 상금을 계산( 구입 금액 / 총 당첨 금액 )- **calculateMoneyByMatchingNumbers**