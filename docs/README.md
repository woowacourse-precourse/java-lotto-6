## 기능목록


- 구입 금액을 입력받아서 저장한다. 에러메세지가 뜨면 다시 입력받는다. LottoManager#insertMoney
    - 금액을 1000으로 나눈 나머지가 0이 아니면 에러메세지를 보낸다. LottoManager#checkMoney
    - 에러메세지가 뜨면 다시 입력 받도록 조치한다. LottoManager#insertMoneyErrorHandling    

- 구입 금액을 1000으로 나눠 로또 수량을 저장한다. LottoManager#buyLottoAmount
- 로또 수량을 출력한다. LottoManager#showBuyAmount

- 구입 수량만큼 로또 번호 세트 생성을 반복한다. LottoManager#loopCreateLottoCandidateSets
    - 1~45 사이 독립된 숫자 6개로 구성된 로또 번호 한 세트를 생성한다. LottoManager#createLottoCandidateSet
- 생성한 각 로또 번호 세트 출력을 반복한다. LottoManager#showAllLottoCandidateSets
    - 생성한 로또 한 세트를 출력한다. LottoManger#showLottoCandidateSet

- 숫자를 쉼표로 구분해, 당첨 번호 한 세트를 입력받되, 에러메세지가 뜨면 다시 입력받는다. LottoManager#insertLottoNumbers 
    - 당첨 번호 세트를 저장할 객체 Lotto를 생성한다. Lotto#Lotto
    - 에러메세지가 뜨면 다시 입력 받도록 조치한다. LottoManager#insertLottoNumbersErrorHandling
    - 입력 세트의 숫자 개수가 정확히 6개가 아니면 에러메세지를 보낸다. Lotto#validate
    - 당첨 번호의 각 숫자가 1~45 범위 밖에 있는지 확인한다. Lotto#loopCheckNumberRange
        - 한 숫자가 1~45 범위 밖에 있으면 에러메세지를 보낸다. Lotto#checkNumberRange
    - 당첨 번호의 각 숫자가 중복되었는지 확인하다. Lotto#checkSameNumber

- 보너스 번호로 숫자 한개를 입력받되, 에러메세지가 뜨면 다시 입력받는다. LottoManger#insertBonusNumber
    - 숫자가 1~45 범위 밖이면 에러메세지를 보낸다. LottoManager#checkBonusNumberRange
    - 에러메세지가 뜨면 다시 입력받는다. LottoManger#insertBonusNumberErrorHandling
    - 보너스 번호가 당첨 번호에 속하면 에러메세지를 보낸다. LottoManger#checkBonusNumberInLottoNumbers
        - 당첨 번호 불러온다. Lotto#getNumbers    

- 생성한 각 로또 세트의 당첨 여부를 확인한다. LottoManager#loopJudgeLottoCandidateSetsResult
    - 한 로또 세트의 당첨 여부를 확인한다. LottoManager#judgeLottoCandiateSetResult
        - Lotto의 당첨 번호와 한 세트의 번호가 몇 개 일치하는 지 확인한다. LottoManager#countCorrectNumbers
        - 당첨 번호와의 일치 개수에 따라 등수를 판단하고, 당첨 복권 수량을 관리하는 리스트에, 해당 등수의 당첨 복권 수량을 추가한다. LottoManager#addWinNumbers

- 5등부터 1등까지, 당첨 조건(숫자 일치 개수), 당첨금, 당첨 수량을 차례로 표시한다. LottoManager#showResult
- 수익금을 구입금액으로 나누고, 소수 둘째자리에서 반올림해서 수익률을 표시한다. LottoManager#showReturnRate
    - 당첨 복권 수량 리스트의 각 등수의 당첨 개수와 당첨금을 곱하고 그들의 합을 계산한다. LottoManager#sumWinMoney
