package bank.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BankAccountRepository : JpaRepository<BankAccountEntity, UUID>