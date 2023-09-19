package bank.adapter.`in`.web

import bank.adapter.`in`.web.model.BankAccountCreateRequest
import bank.application.port.`in`.BankAccountCreateUseCase
import bank.application.port.`in`.command.BankAccountCreateCammand
import bank.domain.BankAccount
import common.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.net.URI

@WebAdapter(path = "/bankaccount")
class BankAccountCreateController(
    private val bankAccountCreateUseCase: BankAccountCreateUseCase
) {

    @PostMapping
    fun bankAccountCreate(
        @RequestBody bankAccountCreateRequest: BankAccountCreateRequest
    ): ResponseEntity<BankAccount> {

        val bankAccountCreateCammand = BankAccountCreateCammand(
            memberId = bankAccountCreateRequest.memberId,
            bankName = bankAccountCreateRequest.bankName,
            accountNumber = bankAccountCreateRequest.accountNumber
        )

        val bankAccount = bankAccountCreateUseCase.bankAccountCreate(bankAccountCreateCammand)
        return ResponseEntity.created(URI.create("/bankaccount/" + bankAccount.id)).body(bankAccount)
    }

}