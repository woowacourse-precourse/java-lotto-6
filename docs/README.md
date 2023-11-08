<h2>로또 게임</h2>

---

- `사용자 input` 입력받기
  1. 구입 금액
  2. winning nums 정하기
  3. 보너스 번호 정하기


- `model`에서 처리할 일
    1. 로또 구매 수량 계산
   2. 로또 개수에 맞는 번호 생성
  3. 당첨 확인
  4. 결과 산출



---


- 사용자 입력<br>
ㄴ UserInput<br/><br/>

- 모델1(로또 번호 생성)<br>
  ㄴ PurchaseLottoModel <br/>
- 모델2(비교를 통해 등수 확인)<br>
  ㄴ RankCalculateModel <br/>
- 모델3(총 금액, 수익률 계산)<br>
  ㄴ MoneyCalculateModel <br/>
- 산출(결과, 수익률)
  <br/><br/>
- 필요한 자료 체계<br>
  ㄴ Lotto <br/>
  ㄴ Rank -> Enum class로 설정 <br/>

