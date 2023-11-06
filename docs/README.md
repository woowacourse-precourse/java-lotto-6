## 기능 목록

- [X] 로또 구입 금액을 입력받는다.  - LottoController # requestAmount()
  - [X] 입력받은 금액이 올바른지 확인한다. - InputValidator # amountValidator()
    - - [X] 잘못된 입력을 받았을 경우 옳은 입력을 받을 때 까지 다시 입력받는다. - LottoController # requestAmount()
- [X] 입력 받은 금액에 맞는 개수의 로또 번호를 발급받는다. - LottoController # requestMyLotto()
- [X] 당첨 번호를 입력받는다. - LottoController # requestLotto()
- [X] 보너스 번호를 입력받는다. - LottoController # requestBonus()
  - [X] 입력받은 번호가 올바른지 확인한다. - InputValidator # lottoValidator(), bonusValidator()
    - [X] 잘못된 입력을 받았을 경우 옳은 입력을 받을 때 까지 다시 입력받는다. - LottoController # requestLotto(), requestBonus()
- [x] 발급받은 로또 번호와 입력한 번호들을 비교한다. - LottoService # resultLotto()
  - [X] 일치한 개수에 맞는 반환값을 출력한다. - LottoService # compareLotto()
  - [X] 해당 반환값들을 이용하여 총 수익률을 출력한다. - LottoService # rateReturn()


- 에러 상황시의 에러 문구는 반드시"[ERROR]"로 시작해야 한다.


#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---


## 프로그래밍 추가 요구사항

1. 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
2. else 예약어를 쓰지 않는다.
3. JAVA Enum을 적용한다.
4. 도메인 로깆에 단위 테스트를 구현해야 한다. 단, UI로직은 제외

