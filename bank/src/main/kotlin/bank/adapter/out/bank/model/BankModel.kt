package bank.adapter.out.bank.model

data class FirmBankReqeust(
    val fromBankName: String,
    val fromAccountNumber: String,
    val toBankName: String,
    val toAccountNumber: String,
)

data class FirmBankResponse(
    val success: Boolean
)