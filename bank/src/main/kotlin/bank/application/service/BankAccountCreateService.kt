package bank.application.service

import bank.application.port.`in`.BankAccountCreateUseCase
import bank.application.port.`in`.command.BankAccountCreateCammand
import bank.application.port.out.BankAccountCreatePort
import bank.application.port.out.BankAccountInformationPort
import bank.domain.BankAccount
import example.application.UseCase
import example.application.port.out.MemberFindPort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class BankAccountCreateService(
    private val bankAccountCreatePort: BankAccountCreatePort,
    private val bankAccountInformationPort: BankAccountInformationPort,
    private val memberFindPort: MemberFindPort,
) : BankAccountCreateUseCase {

    override fun bankAccountCreate(bankAccountCreateCammand: BankAccountCreateCammand): BankAccount {

        // 1. 계좌가 정상인지 외부 은행 API를 통한 확인
        val bankAccountInformation = bankAccountInformationPort.bankAccountInformation(
            bankAccountCreateCammand.bankName,
            bankAccountCreateCammand.accountNumber
        )

        if (!bankAccountInformation.valid) {
            throw IllegalStateException()
        }

        // 2. 회원이 유효한지 확인
        val findMember = memberFindPort.findMember(bankAccountCreateCammand.memberId) ?: throw NoSuchElementException()
        if (!findMember.valid) {
            throw IllegalStateException()
        }

        return bankAccountCreatePort.bankAccountCreate(
            memberId = bankAccountCreateCammand.memberId,
            bankName = bankAccountCreateCammand.bankName,
            accountNumber = bankAccountCreateCammand.accountNumber
        )
    }

}