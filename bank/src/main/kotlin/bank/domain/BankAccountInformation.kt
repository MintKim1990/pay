package bank.domain

// 실제 은행 API에서 조회되는 계좌정보
class BankAccountInformation(
    var bankName: String,
    var accountNumber: String,
    var valid: Boolean = true
)