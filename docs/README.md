<p align="center">
    <img src="https://i.ibb.co/ScdBqFT/logo-light.png" alt="우아한테크코스" width="250px">
</p>

# 프리코스 3주차 미션 - 로또 미션

---

![Generic badge](https://img.shields.io/badge/precourse-week3-green.svg)
![Generic badge](https://img.shields.io/badge/test-2_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 6기 3주차 미션, 로또 미션을 구현한 저장소입니다.

<br>
<img src="./operation.png">

# 목차

- [기능 목록](#기능-목록)
    - [로또 구입](#로또-구입)
    - [당첨 번호 입력](#로또-당첨-번호)
    - [보너스 번호 입력](#로또-보너스-번호)
    - [당첨 통계 출력](#로또-당첨-통계-출력)
- [패키지 구조](#패키지 구조)

---

## 기능 목록

### 로또 구입

- `구입금액을 입력해 주세요.` 가 콘솔에 출력된다
- 사용자로부터 구입 금액을 입력받는다
  - 잘못 입력된 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료시킨다
  - 정상 입력된 경우 로또 구매를 시작한다.
    - `4개를 구매했습니다.` 와 같이 로또 구매 개수를 표기한다
    - 구매 로또 번호 내역이 출력된다
    - ```
      [8, 21, 23, 41, 42, 43]
      [3, 5, 11, 16, 32, 38]
      [7, 11, 16, 35, 36, 44]
      [1, 8, 11, 31, 41, 42]
        ```

### 당첨 번호 입력
- `당첨 번호를 입력해 주세요.` 가 콘솔에 출력된다
- 사용자로부터 당첨 번호 입력을받는다
  - ex) `1,2,3,4,5,6`
- 잘못 입력된 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료시킨다

### 보너스 번호 입력
- `보너스 번호를 입력해 주세요` 가 콘솔에 출력된다
- 사용자로부터 보너스 번호를 입력받는다
  - ex) `7`
- 잘못 입력된 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료시킨다

### 당첨 통계 출력
- 당첨 통계가 출력된다
```
당첨 통계
---
3개 일치 (5,000원) - 0개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 0.0%입니다.
```

---

## 패키지 구조

- controller
  - LottoController: Model과 View 중재 역할
- model
  - constant
    - LottoConfig: LottoConfing 상수들을 모아놓은 클래스
  - Lotto
    - sameNumberCounter: 같은 숫자 개수 반환 기능
    - hasNumber: 숫자가 포함 되는지 판단 기능
  - LottoResult
    - calculatePrice: 누적 상금 계산 기능
    - getRankCount: 당첨 횟수 확인 기능
  - Lottos : 로또들을 보관하는 기능
  - Money
    - availableLottoCount: 구매 가능 로또 개수 계산 기능
  - WinningNumbers
    - hasNumber: 같은 숫자 개수 반환 기능
  - PriceMoney: 상금 관련 Enum
- view
  - constant
    - viewMessage: 입,출력 뷰 메세지 관리 클래스
  - validation
    - InputValidation
      - 빈칸 입력 검증 기능
      - 공백 입력 검증 기능
  - InputView
    - inputMoney: 구매 금액 입력 기능
    - inputWinningNumbers: 당첨 번호 입력 기능
    - inputBonusNumber: 보너스 번호 입력 기능
  - OutputView
    - outputPurchaseLottos: 구매한 로또 목록 출력 기능
    - outputWinningResult: 구매 통계 출력 기능