package bank.application.port.`in`

import bank.application.port.`in`.command.BankAccountCreateCammand
import bank.domain.BankAccount

interface BankAccountCreateUseCase {

    fun bankAccountCreate(bankAccountCreateCammand: BankAccountCreateCammand): BankAccount

}