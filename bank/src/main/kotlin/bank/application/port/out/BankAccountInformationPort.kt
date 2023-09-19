package bank.application.port.out

import bank.domain.BankAccountInformation

interface BankAccountInformationPort {
    fun bankAccountInformation(bankName: String, accountNumber: String): BankAccountInformation
}