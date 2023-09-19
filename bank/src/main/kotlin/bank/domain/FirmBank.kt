package bank.domain

import java.util.*

class FirmBank(
    var id: UUID? = null,
    var fromBankName: String,
    var fromAccountNumber: String,
    var toBankName: String,
    var toAccountNumber: String,
    var money: Int,
    var status: FirmBankStatus,
)