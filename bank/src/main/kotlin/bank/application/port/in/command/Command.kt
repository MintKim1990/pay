package bank.application.port.`in`.command

import example.application.port.`in`.command.CommandValidator
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class BankAccountCreateCammand(
    @field:NotNull
    var memberId: Long,
    @field:NotBlank
    var bankName: String,
    @field:NotBlank
    var accountNumber: String,
) : CommandValidator<BankAccountCreateCammand>()

data class FirmBankRequestCommand(
    @field:NotBlank
    var fromBankName: String,
    @field:NotBlank
    var fromAccountNumber: String,
    @field:NotBlank
    var toBankName: String,
    @field:NotBlank
    var toAccountNumber: String,
    @field:NotNull
    var money: Int
)