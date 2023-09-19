package bank.adapter.out.persistence

import bank.application.port.out.BankAccountCreatePort
import bank.domain.BankAccount
import common.PersistenceAdapter

@PersistenceAdapter
class BankAccountPersistenceAdapter(
    private val bankAccountRepository: BankAccountRepository,
    private val bankAcountMapper: BankAcountMapper,
) : BankAccountCreatePort {

    override fun bankAccountCreate(memberId: Long, bankName: String, accountNumber: String): BankAccount {
        val bankAccountEntity = BankAccountEntity(
            memberId = memberId,
            bankName = bankName,
            accountNumber = accountNumber
        )

        bankAccountRepository.save(bankAccountEntity)
        return bankAcountMapper.toBankAccount(bankAccountEntity)
    }

}