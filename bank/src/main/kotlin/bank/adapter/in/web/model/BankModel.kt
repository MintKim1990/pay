package bank.adapter.`in`.web.model

data class BankAccountCreateRequest(
    var memberId: Long,
    var bankName: String,
    var accountNumber: String,
)

data class FirmBankCreateRequest(
    var fromBankName: String,
    var fromAccountNumber: String,
    var toBankName: String,
    var toAccountNumber: String,
    var money: Int
)