package bank.domain

import java.util.UUID

class BankAccount(
    var id: UUID,
    var memberId: Long,
    var bankName: String,
    var accountNumber: String,
    var valid: Boolean
)