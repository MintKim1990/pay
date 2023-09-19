package bank.adapter.out.bank

import bank.adapter.out.bank.model.FirmBankReqeust
import bank.adapter.out.bank.model.FirmBankResponse
import bank.application.port.out.BankAccountInformationPort
import bank.application.port.out.FirmBankRequestPort
import bank.domain.BankAccountInformation
import common.Adapter
import org.springframework.web.client.RestTemplate

@Adapter
class BankRequestAdapter(
    private val restTemplate: RestTemplate
) : BankAccountInformationPort, FirmBankRequestPort {
    override fun bankAccountInformation(bankName: String, accountNumber: String): BankAccountInformation {
        // 은행 계좌조회 API를 RestTemplate를 이용하여 호출한다고 가정
        return BankAccountInformation(
            bankName = bankName,
            accountNumber = accountNumber,
            true
        )
    }

    override fun request(firmBankReqeust: FirmBankReqeust): FirmBankResponse {
        // 은행 입금, 출금 API를 RestTemplate를 이용하여 호출한다고 가정
        return FirmBankResponse(true)
    }

}