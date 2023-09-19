package bank.adapter.out.persistence

import bank.domain.BankAccount
import bank.domain.FirmBank
import org.springframework.stereotype.Component

@Component
class FirmBankMapper {
    fun toFirmBank(firmBankEntity: FirmBankEntity): FirmBank {
        return FirmBank(
            id = firmBankEntity.id,
            fromBankName = firmBankEntity.fromBankName,
            fromAccountNumber = firmBankEntity.fromAccountNumber,
            toBankName = firmBankEntity.toBankName,
            toAccountNumber = firmBankEntity.toAccountNumber,
            money = firmBankEntity.money,
            status = firmBankEntity.status
        )
    }
}