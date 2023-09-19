package bank.adapter.out.persistence

import bank.application.port.out.FirmBankCreatePort
import bank.domain.FirmBank
import common.PersistenceAdapter

@PersistenceAdapter
class FirmBankPersistenceAdapter(
    private val firmBankRepository: FirmBankRepository,
    private val firmBankMapper: FirmBankMapper,
) : FirmBankCreatePort {

    override fun firmBankCreate(firmBank: FirmBank): FirmBank {

        val firmBankEntity = FirmBankEntity(
            fromBankName = firmBank.fromBankName,
            fromAccountNumber = firmBank.fromAccountNumber,
            toBankName = firmBank.toBankName,
            toAccountNumber = firmBank.toAccountNumber,
            money = firmBank.money,
            status = firmBank.status
        )

        firmBankRepository.save(firmBankEntity)
        return firmBankMapper.toFirmBank(firmBankEntity)
    }

}