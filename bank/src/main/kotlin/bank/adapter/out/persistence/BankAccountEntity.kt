package bank.adapter.out.persistence

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bankaccount")
class BankAccountEntity(
    @Id
    var id: UUID = UUID.randomUUID(),
    var memberId: Long,
    var bankName: String,
    var accountNumber: String,
    var valid: Boolean = true
)