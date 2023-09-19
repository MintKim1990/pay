package bank.application.service

import bank.adapter.out.bank.model.FirmBankReqeust
import bank.application.port.`in`.FirmBankCreateUseCase
import bank.application.port.`in`.command.FirmBankRequestCommand
import bank.application.port.out.FirmBankCreatePort
import bank.application.port.out.FirmBankRequestPort
import bank.domain.FirmBank
import bank.domain.FirmBankStatus
import example.application.UseCase
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
class FirmBankCreateService(
    private val firmBankCreatePort: FirmBankCreatePort,
    private val firmBankRequestPort: FirmBankRequestPort,
) : FirmBankCreateUseCase {

    override fun request(firmBankRequestCommand: FirmBankRequestCommand): FirmBank {

        // 입금, 출금요청에 대한 로깅목적으로 요청정보 저장
        val firmBank = FirmBank(
            fromBankName = firmBankRequestCommand.fromBankName,
            fromAccountNumber = firmBankRequestCommand.fromAccountNumber,
            toBankName = firmBankRequestCommand.toBankName,
            toAccountNumber = firmBankRequestCommand.toAccountNumber,
            money = firmBankRequestCommand.money,
            status = FirmBankStatus.REQUEST
        )

        firmBankCreatePort.firmBankCreate(firmBank)

        // 외부 은행에 입금, 출금요청
        val firmBankReqeust = FirmBankReqeust(
            fromBankName = firmBankRequestCommand.fromBankName,
            fromAccountNumber = firmBankRequestCommand.fromAccountNumber,
            toBankName = firmBankRequestCommand.toBankName,
            toAccountNumber = firmBankRequestCommand.toAccountNumber
        )

        val firmBankResponse = firmBankRequestPort.request(firmBankReqeust)
        // 입금, 출금 은행 API 요청 결과에 따른 결과 저장
        val resultFirmBank = FirmBank(
            fromBankName = firmBankRequestCommand.fromBankName,
            fromAccountNumber = firmBankRequestCommand.fromAccountNumber,
            toBankName = firmBankRequestCommand.toBankName,
            toAccountNumber = firmBankRequestCommand.toAccountNumber,
            money = firmBankRequestCommand.money,
            status = if(firmBankResponse.success) FirmBankStatus.COMPLETED else FirmBankStatus.FAIL
        )

        return firmBankCreatePort.firmBankCreate(firmBank)
    }

}