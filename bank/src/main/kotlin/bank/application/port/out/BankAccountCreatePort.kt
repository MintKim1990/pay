package bank.application.port.out

import bank.domain.BankAccount

interface BankAccountCreatePort {

    fun bankAccountCreate(memberId: Long, bankName: String, accountNumber: String): BankAccount

}