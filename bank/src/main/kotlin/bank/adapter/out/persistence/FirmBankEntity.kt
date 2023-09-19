package bank.adapter.out.persistence

import bank.domain.FirmBankStatus
import java.util.*
import javax.persistence.Id

class FirmBankEntity(
    @Id
    var id: UUID = UUID.randomUUID(),
    var fromBankName: String,
    var fromAccountNumber: String,
    var toBankName: String,
    var toAccountNumber: String,
    var money: Int,
    var status: FirmBankStatus,
)