package bank.application.port.out

import bank.domain.FirmBank

interface FirmBankCreatePort {

    fun firmBankCreate(firmBank: FirmBank) : FirmBank

}