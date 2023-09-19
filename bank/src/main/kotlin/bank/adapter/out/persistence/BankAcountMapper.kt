package bank.adapter.out.persistence

import bank.domain.BankAccount
import org.springframework.stereotype.Component

@Component
class BankAcountMapper {

    fun toBankAccount(bankAccountEntity: BankAccountEntity): BankAccount {
        return BankAccount(
            id = bankAccountEntity.id,
            memberId = bankAccountEntity.memberId,
            bankName = bankAccountEntity.bankName,
            accountNumber = bankAccountEntity.accountNumber,
            valid = bankAccountEntity.valid
        )
    }

}