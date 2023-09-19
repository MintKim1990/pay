package bank.application.port.`in`

import bank.application.port.`in`.command.FirmBankRequestCommand
import bank.domain.FirmBank

interface FirmBankCreateUseCase {
    fun request(firmBankRequestCommand: FirmBankRequestCommand): FirmBank
}