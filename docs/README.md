## 입력 - Input

- [x] 금액 - **amount**
- [x] 당첨 번호 - **winningNumber**
- [x] 보너스 번호 - **bonusNumber**

## 출력 - Output

- [x] 로또 발행 개수 - **printPurchasedLottoCount**
- [x] 로또 번호 - **printPurchasedLottoNumbers**
- [x] 등수별 당첨 내역 - **printWinningResultsByRank**
- [x] 수익률 - **printProfitRate**

## 자료형 변환 - **TypeConverter**

- [x] String > int - **stringToInt**
- [x] String > ArrayList(쉼표로 구분) - **stringToArrayList**

## 예외 처리 - **ExceptionHandler**

- [x] 0 이하의 값이 아닌지 (구매 금액) - **checkNonNegativeAmount**
- [x] 1,000원으로 나누어 떨어지는 지 (구매 금액) - **checkMultipleOfThousand**-
- [x] null 값 확인 (ArrayList, int) - **checkNotNull**
- [x] 빈값 확인(띄어쓰기) - **checkNotEmpty**
- [x] 숫자인지 (ArrayList, int) - **checkInteger**
- [x] 중복값 확인 - **checkDuplicates**
- [x] 1~45사이의 수인지 - **checkInRange**
- [x] 6개의 숫자인지 (당첨 번호) - **checkSixNumbers**
- [x] 1개의 숫자인지 (보너스 번호) - **checkSingleNumber**

## 구매 금액 - PurchaseAmount

- [x] 입력된 금액 콤마 제거 (있을 경우) - **removeComma**
- [x] 입력된 금액 띄어쓰기 제거 (있을 경우) - **removeEmpty**
- 예외 처리 - **vali원date**
  - [x] null 값 확인
  - [x] 숫자인지
  - [x] 0 이하의 값이 아닌지
  - [x] 1,000원으로 나누어 떨어지는 지

## 구매 로또 - PurchaseLotto

- [x] 1~45 사이의 숫자로 이루어진 중복되지 않는 6개의 로또 번호를 생성 - **createLottoNumbers**
- [x] 입력된 금액에 따라 로또를 발행 - **purchaseLotto**


## 당첨 로또 - Lotto

- 예외 처리 - **validate**
  - [x] null 값 확인
  - [x] 숫자인지
  - [x] 중복값 확인
  - [x] 6개의 숫자인지
  - [x] 1~45 사이의 값인지

## 보너스 번호 - BonusNumber

- 예외 처리 - **validate**
  - [x] null 값 확인
  - [x] 숫자인지
  - [x] 당첨 번호와 중복값 확인
  - [x] 1~45 사이의 값인지

## 당첨 - Match

- [x] 사용자의 로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 반환 (HashSet) - **checkMatchingNumbers**

## 수익률 - ProfitRate

- [x] 일치하는 번호의 개수에 따라 상금을 계산( 구입 금액 / 총 당첨 금액 )- **calculateTotalPrizeAmount**
- [x] 수익률 - **calculateProfitRate**