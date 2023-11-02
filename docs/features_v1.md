# 설계

# DOMAIN

## MONEY

### `class Money`: 금액 검증 및 표시

---

### `class Wallet`: 잔액을 담을 수 있는 지갑을 표현

    - [ ] 필드:
      `Money remainedMoney`

---

## LOTTO

### `class Lotto`: 로또 번호 6자리를 담은 티켓

    - [ ] 필드:
      `List <Integer> numbers`: 로또 번호 6자리

    - [ ] 기능:
      `boolean contains(int): 특정 숫자 포함 여부 반환
      `int count`

### `class Lottos`: 로또 일급 컬렉션

    - [ ] 필드:
      `List <Integer> numbers`: 로또 번호 6자리

---

## `class LottoDispenser`: 로또 발행기

    - [ ] 필드:
      `List <Integer> numbers`: 로또 번호 6자리

    - [ ] 기능:
      `Lotto dispense()`: 로또 발행 기능

---

## `interface SizedNumbersGenerator`: N자리의 랜덤 숫자 배열 반환

    - [ ] 필드:

    - [ ] 기능:
      `List <Integer> generate`: N자리의 랜덤 숫자 리스트 반환

  
---

## `class LottoStore`: 로또 판매점

    - [ ] 필드:
      `static Money PRICE_PER_LOTTO`
      `List <Integer> numbers`: 로또 번호 6자리

    - [ ] 기능:
      `buyUntilOutOfMoney`: 가진 금액을 모두 소진할 때까지 로또 구매

---

## `class LottoDrawingMachine`: 로또 번호 추첨 기계

    - [ ] 필드:
      `List <Integer> numbers`: 당첨 번호 6자리
      `int bonusNumber`: 보너스 번호
      
    - [ ] 기능:
      `LottoRrawingResult draw(Lotto)`: 로또 티켓을 받아서 당첨 번호 및 보너스 번호와 비교 및 결과 반환

---

# DTO

## `enum LottoDrawingResult`: 로또 당첨 결과

    - [ ] 필드:
      `int place`: 등수
      `int price`: 당첨 금액
      `int matchCount`: 일치하는 번호 갯수
      `boolean hasBonusNumber`: 보너스 번호 유무
      
    - [ ] 기능:
      `draw(matchCount, hasBonusNumber)`: 일치하는 갯수와 보너스 번호 유무를 토대로 등수에 해당하는 enum constant 반환

---



